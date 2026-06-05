package facade;

import database.LibraryRepository;
import entity.Book;
import entity.Transaction;
import entity.User;
import java.time.LocalDate;
import strategy.SortContext;
import strategy.SortStrategyInterface;

//service layer
public class LibraryFacade {
    private LibraryRepository database;

    //Constructor-based Dependency Injection, D in SOLID
    //depends on the interface, unknown about the real database
    public LibraryFacade(LibraryRepository database) {
        this.database = database;
    }

    //High authority methods
    //Member methods
    
    public boolean addMember(User user) {
        return database.addMember(user);
    }

    public boolean findMember(int id) {
        return database.findMember(id);
    }

    public User findMember(String name) {
        return database.findMember(name);
    }

    public String showMemberList(){
        StringBuilder sb = new StringBuilder();
        sb.append("Member List:\n");
        for (User member : database.getMembersList()) {
            sb.append(member.toString()).append("\n");
        }
        return sb.toString();
    }

    //Transaction methods, sace transaction to database
    //saveTransaction is private since it is only used internally by the facade, and not exposed to the client
    private void saveTransaction(Transaction transaction) {
        database.addTransaction(transaction);
    }

    public String showTransactionHistory() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction History:\n");
        for (Transaction transaction : database.getTransactionsList()) {
            sb.append(transaction.toString()).append("\n");
        }
        return sb.toString();
    }

    //Book methods
    private static int bookIdCounter = 1;
    public boolean addBook(String title, String category, String author, LocalDate publishedDate) {
        return database.addBook(new Book(bookIdCounter++, title, category, author, publishedDate));
    }

    public boolean findBook(int id) {
        return database.findBook(id);
    }

    public Book findBookTitle(String title) {
        return database.findBookByTitle(title);
    }

    public boolean removeBook(int id) {
        return database.removeBook(id);
    }

    public String showBookList() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book List:\n");
        for (Book book : database.getBooksList()) {
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }

    //low authority methods
    //Book state methods - methods for borrowing, returning, and reserving books
    public String borrowBook(String bookTitle, User user) {
        Book book = findBookTitle(bookTitle);
        //if book not in database, unable to borrow the book
        if(!findBook(book.getID())) {
            return "Book not found in database";
        }

        // if user not registered
        if(!findMember(user.getId())) {
            return "User not found in database";
        }

        //if book is available, set state to Borrowed, and save transaction to database
        if (book.borrow()) {
            LocalDate transactionDate = LocalDate.now();
            LocalDate returnDate = transactionDate.plusDays(14); 
            Transaction transaction = new Transaction(Transaction.TransactionType.BORROW, book, user, transactionDate, returnDate);
            saveTransaction(transaction);
            return "Book borrowed successfully";
        } 
        else return "Book is not available for borrowing";
    }

    public String reserveBook(String bookTitle, User user) {
        Book book = findBookTitle(bookTitle);
        //if book not in database, unable to borrow the book
        if(!findBook(book.getID())) {
            return "Book not found in database";
        }

        // if user not registered
        if(!findMember(user.getId())) {
            return "User not found in database";
        }
        
        //if book is available, set state to Reserved, and save transaction to database
        if (book.reserve()) {
            LocalDate transactionDate = LocalDate.now();
            Transaction transaction = new Transaction(Transaction.TransactionType.RESERVE, book, user, transactionDate);
            saveTransaction(transaction);
            return "Book reserved successfully";
        }
    
        //if book is not available, unable to reserve the book
        else return "Book is not available for reservation";
    }

    public String cancelReservation(String bookTitle, User user) {
        Book book = findBookTitle(bookTitle);
        //if book not in database, unable to borrow the book
        if(!findBook(book.getID())) {
            return "Book not found in database";
        }

        // if user not registered
        if(!findMember(user.getId())) {
            return "User not found in database";
        }

        //if book is reserved, set state to Available, and save transaction to database
        if (book.cancelReservation()) {
            LocalDate transactionDate = LocalDate.now();
            Transaction transaction = new Transaction(Transaction.TransactionType.CANCEL_RESERVATION, book, user, transactionDate);
            saveTransaction(transaction);
            return "Reservation cancelled successfully";
        }

        //if book is not reserved, unable to cancel reservation
        else return "Book is not reserved";
    }

    public void sortBooks(SortStrategyInterface<Book> strategy) {
        SortContext<Book> sortContext = new SortContext<>(strategy);
        sortContext.executeSort(database.getBooksList());
    }

    public void sortTransactions(SortStrategyInterface<Transaction> strategy) {
        SortContext<Transaction> sortContext = new SortContext<>(strategy);
        sortContext.executeSort(database.getTransactionsList());
    }

    public String returnBook(String bookTitle, User user) {
        Book book = findBookTitle(bookTitle);
        //if book not in database, unable to borrow the book
        if(!findBook(book.getID())) {
            return "Book not found in database";
        }

        // if user not registered
        if(!findMember(user.getId())) {
            return "User not found in database";
        }

        //if book is borrowed, set state to Available, and save transaction to database
        if (book.returnBook()) {
            LocalDate transactionDate = LocalDate.now();
            Transaction transaction = new Transaction(Transaction.TransactionType.RETURN, book, user, transactionDate, book.getState());
            database.addTransaction(transaction);
            return "Book returned successfully";
        }

        //if book is not borrowed, unable to return the book
        else return "Book is not borrowed";
    
    }

    

}
