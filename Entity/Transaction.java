package Entity;
public class Transaction {
    Book book;
    User user;
    String transactionDate;
    String returnDate;
    public Transaction(Book book, User user, String transactionDate, String returnDate) {
        this.book = book;
        this.user = user;
        this.transactionDate = transactionDate;
        this.returnDate = returnDate;
    }
    
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
    public String getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    
}
