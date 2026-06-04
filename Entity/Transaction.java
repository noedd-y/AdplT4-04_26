package entity;

public class Transaction {
    enum TransactionType {
        BORROW, RETURN, RESERVE, CANCEL_RESERVATION
    }
    Book book;
    User user;
    String transactionDate;
    String returnDate;
    String state;
    TransactionType type;
    //default constructor, for reserve and cancel reserve transaction
    //transaction type is in param to explicitly indicate the type of transaction (instead of choosing the constructor based on the transaction type, which is less clear)
    public Transaction(TransactionType type, Book book, User user, String transactionDate) {
        this.book = book;
        this.user = user;
        this.transactionDate = transactionDate;
        this.type = type;
        //not used for reserve and cancel reserve transaction, since they dont have return date and state
        this.returnDate = null;
        this.state = null;
    }

    //constructor for borrow transaction and return transaction, have additional date
    public Transaction(TransactionType type, Book book, User user, String transactionDate, String data) {
        this(type, book, user, transactionDate);
        if(type == TransactionType.BORROW) {
            this.returnDate = data;
        } else if(type == TransactionType.RETURN) {
            this.state = data;
        }
    }
}