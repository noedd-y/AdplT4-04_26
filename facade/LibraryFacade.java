package facade;

import java.time.LocalDate;

import database.LibraryDatabase;
import entity.*;

public class LibraryFacade {
    private LibraryDatabase database;

    public LibraryFacade() {
        database = LibraryDatabase.getInstance();
    }

    //Member methods
    public void addMember(User user) {
        database.addMember(user);
    }

    //Transaction methods, sace transaction to database
    //saveTransaction is private since it is only used internally by the facade, and not exposed to the client
    private void saveTransaction(Transaction transaction) {
        database.saveTransaction(transaction);
    }

    //Book methods
    public void addBook(Book book) {
        database.addBook(book);
    }

    public boolean removeBook(Book book) {
        boolean found = database.findBook(book);
        if (!found) {
            System.out.println("Book not found in database");
            return false;
        }
        database.removeBook(book);
        return true;
    }

    //Book state methods - methods for borrowing, returning, and reserving books
    public String borrowBook(Book book, User user) {
        //if book not in database, unable to borrow the book
        if(!database.findBook(book)) {
            return "Book not found in database";
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
}
