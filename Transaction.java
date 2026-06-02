public class Transaction {
    Book book;
    Member member;
    String transactionDate;
    String returnDate;
    public Transaction(Book book, Member member, String transactionDate, String returnDate) {
        this.book = book;
        this.member = member;
        this.transactionDate = transactionDate;
        this.returnDate = returnDate;
    }
    
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Member getMember() {
        return member;
    }
    public void setMember(Member member) {
        this.member = member;
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
