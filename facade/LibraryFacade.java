package facade;

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

    //Transaction methods
    public void saveTransaction(Transaction transaction) {
        database.saveTransaction(transaction);
    }

    // public Transaction createTransaction(Book book, User user) {
        
    //     Transaction transaction = new Transaction(book, user, "2024-06-01", "2024-06-15");
    //     return database.createTransaction(book, user);
    // }

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
            String transactionDate = "2024-06-01"; // Example transaction date
            String returnDate = "2024-06-15"; // Example return date
            Transaction transaction = new Transaction(book, user, transactionDate, returnDate);
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
            String transactionDate = "2024-06-01"; // Example transaction date
            String returnDate = "2024-06-15"; // Example return date
            Transaction transaction = new Transaction(book, user, transactionDate, returnDate);
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
            String transactionDate = "2024-06-01"; // Example transaction date
            String returnDate = "2024-06-15"; // Example return date
            Transaction transaction = new Transaction(book, user, transactionDate, returnDate);
            saveTransaction(transaction);
            return "Book reserved successfully";
        }
    
        //if book is not available, unable to reserve the book
        else return "Book is not available for reservation";

    }
}
