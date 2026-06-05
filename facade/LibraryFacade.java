package facade;

import database.LibraryDatabase;
import entity.*;
import java.time.LocalDate;

import strategy.*;
import strategy.booksort.*;
import strategy.transactionsort.*;

public class LibraryFacade {
    private LibraryDatabase database;

    public LibraryFacade() {
        database = LibraryDatabase.getInstance();
    }

    //High authority methods
    //Member methods
    public boolean addMember(User user) {
        return database.addMember(user);
    }

    public boolean findMember(User user) {
        return database.findMember(user);
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
        database.saveTransaction(transaction);
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
    public boolean addBook(Book book) {
        return database.addBook(book);
    }

    public boolean findBook(Book book) {
        return database.findBook(book);
    }

    public boolean removeBook(Book book) {
        return database.removeBook(book);
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
    public String borrowBook(Book book, User user) {
        //if book not in database, unable to borrow the book
        if(!findBook(book)) {
            return "Book not found in database";
        }

        // if user not registered
        if(!findMember(user)) {
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

    public String returnBook(Book book, User user) {
        //if book not in database, unable to return the book
        if(!findBook(book)) {
            return "Book not found in database";
        }

        // if user not registered
        if(!findMember(user)) {
            return "User not found in database";
        }

        //if book is borrowed, set state to Available, and save transaction to database
        if (book.returnBook()) {
            LocalDate transactionDate = LocalDate.now();
            Transaction transaction = new Transaction(Transaction.TransactionType.RETURN, book, user, transactionDate, book.getState());
            saveTransaction(transaction);
            return "Book returned successfully";
        }

        //if book is not borrowed, unable to return the book
        else return "Book is not borrowed";
    
    }

    public String reserveBook(Book book, User user) {
        //if book not in database, unable to reserve the book
        if(!findBook(book)) {
            return "Book not found in database";
        }
        
        // if user not registered
        if(!findMember(user)) {
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

    public String cancelReservation(Book book, User user) {
        //if book not in database, unable to cancel reservation
        if(!findBook(book)) {
            return "Book not found in database";
        }

        // if user not registered
        if(!findMember(user)) {
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

    public void sortBooks(BookSortType cmd, SortDirection dir) {
        SortStrategyInterface<Book> strategy = null;

        switch (cmd) {
            case TITLE:
                strategy = new SortTitle();
                break;
        
            case AUTHOR:
                strategy = new SortAuthor();
                break;

            case CATEGORY:
                strategy = new SortCategory();
                break;

            case DATE:
                strategy = new SortDatePublished();
                break;

            case STATE:
                strategy = new SortState();
                break;
            
            default:
                strategy = new SortTitle();
                break;
        }
        SortContext<Book> sortContext = new SortContext<>(strategy);
        sortContext.executeSort(database.getBooksList(), dir);
    }

    public void sortTransactions(TransactionSortType cmd, SortDirection dir) {
        SortStrategyInterface<Transaction> strategy = null;

        switch (cmd) {
            case TYPE:
                strategy = new SortType();
                break;
        
            case USER:
                strategy = new SortUser();
                break;

            case DATE:
                strategy = new SortTransactionDate();
                break;
            
            default:
                strategy = new SortType();
                break;
        }
        SortContext<Transaction> sortContext = new SortContext<>(strategy);
        sortContext.executeSort(database.getTransactionsList(), dir);
    }
}
