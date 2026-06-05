package entity;

import java.time.LocalDate;

public class Transaction {
    public enum TransactionType {
        BORROW, RETURN, RESERVE, CANCEL_RESERVATION
    }
    Book book;
    User user;
    LocalDate transactionDate;
    LocalDate returnDate;
    String state;
    TransactionType type;
    //default constructor, for reserve and cancel reserve transaction
    //transaction type is in param to explicitly indicate the type of transaction (instead of choosing the constructor based on the transaction type, which is less clear)
    public Transaction(TransactionType type, Book book, User user, LocalDate transactionDate) {
        this.book = book;
        this.user = user;
        this.transactionDate = transactionDate;
        this.type = type;
        //not used for reserve and cancel reserve transaction, since they dont have return date and state
        this.returnDate = null;
        this.state = null;
    }

    //constructor for borrow transaction and return transaction, have additional date
    public Transaction(TransactionType type, Book book, User user, LocalDate transactionDate, LocalDate returnDate) {
        this(type, book, user, transactionDate);
        this.returnDate = returnDate;
    }

    public Transaction(TransactionType type, Book book, User user, LocalDate transactionDate, String state) {
        this(type, book, user, transactionDate);
        this.state = state;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public String getState() {
        return state;
    }

    public TransactionType getType() {
        return type;
    }

    
}