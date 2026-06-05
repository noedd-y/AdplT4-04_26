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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((book == null) ? 0 : book.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
        result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transaction other = (Transaction) obj;
        if (book == null) {
            if (other.book != null)
                return false;
        } else if (!book.equals(other.book))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (transactionDate == null) {
            if (other.transactionDate != null)
                return false;
        } else if (!transactionDate.equals(other.transactionDate))
            return false;
        if (returnDate == null) {
            if (other.returnDate != null)
                return false;
        } else if (!returnDate.equals(other.returnDate))
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (type != other.type)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Transaction [book=" + book + ", user=" + user + ", transactionDate=" + transactionDate + ", returnDate="
                + returnDate + ", state=" + state + ", type=" + type + "]";
    }
}