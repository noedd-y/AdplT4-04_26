package facade;

import database.LibraryDatabase;
import entity.*;
import java.time.LocalDate;
import strategy.*;

public class LibraryFacade {
    private LibraryDatabase database;
    private SortContext sortContext;

    public LibraryFacade() {
        database = LibraryDatabase.getInstance();
        sortContext = new SortContext();
    }

    //High authority methods
    //Member methods
    public boolean addMember(User user) {
        if(database.findMember(user)) {
            System.out.println("User already exists in database");
            return false;
        }
        return database.addMember(user);
    }

    public boolean findMember(User user) {
        return database.findMember(user);
    }

    //Transaction methods, sace transaction to database
    //saveTransaction is private since it is only used internally by the facade, and not exposed to the client
    private void saveTransaction(Transaction transaction) {
        database.saveTransaction(transaction);
    }

    //Book methods
    public boolean addBook(Book book) {
        if (database.findBook(book)) {
            System.out.println("Book already exists in database");
            return false;
        }
        return database.addBook(book);
    }

    public boolean removeBook(Book book) {
        if (!database.findBook(book)) {
            System.out.println("Book not found in database");
            return false;
        }
        return database.removeBook(book);
    }

    //low authority methods
    //Book state methods - methods for borrowing, returning, and reserving books
    public String borrowBook(Book book, User user) {
        //if book not in database, unable to borrow the book
        if(!database.findBook(book)) {
            return "Book not found in database";
        }

        // if user not registered
        if(!database.findMember(user)) {
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
        if(!database.findBook(book)) {
            return "Book not found in database";
        }

        // if user not registered
        if(!database.findMember(user)) {
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
        if(!database.findBook(book)) {
            return "Book not found in database";
        }
        
        // if user not registered
        if(!database.findMember(user)) {
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
        if(!database.findBook(book)) {
            return "Book not found in database";
        }

        // if user not registered
        if(!database.findMember(user)) {
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

    public void sortBooks(SortStrategyInterface strategy) {
        sortContext.setSortStrategy(strategy);
        sortContext.executeSort(database.getBooksList());
    }
}
