package database;
import entity.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import states.LostState;

//repository pattern
public class LibraryDatabase implements LibraryRepository{
    private static LibraryDatabase instance;

    //in-memory database
    private HashMap<Integer, Book> books;
    private HashMap<Integer, User> members;
    private ArrayList<Transaction> transactions;

    private LibraryDatabase() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
        this.transactions = new ArrayList<>();
    }

    //singleton
    public static LibraryDatabase getInstance() {
        if (instance == null) {
            instance = new LibraryDatabase();
        }
        return instance;
    }

    //crud operations for books, members, and transactions
    //books
    @Override
    public boolean addBook(Book target){
        return books.putIfAbsent(target.getID(), target) == null;
    }

    @Override
    public boolean removeBook(int id){
        Book book = books.get(id);
        if (book == null) return false;

        book.setState(new LostState());
        return true;
    }

    @Override
    public boolean findBook(int id){
        return books.containsKey(id);
    }

    public Book findBookByTitle(String title) {
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findBookByAuthor(String Author) {
        List<Book> result = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getAuthor().equalsIgnoreCase(Author)) {
                result.add(book);
            }
        }

        return result;
    }

    public List<Book> findBookByCategory(String Category) {
        List<Book> result = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getCategory().equalsIgnoreCase(Category)) {
                result.add(book);
            }
        }

        return result;
    }

    public List<Book> findBookByPublishedDate(LocalDate date) {
        List<Book> result = new ArrayList<>();

        for (Book book : books.values()) {
            if (Objects.equals(date, book.getPublishedDate())){
                result.add(book);
            }
        }

        return result;
    }
    
    //member
    @Override
    public boolean addMember(User user){
        return members.putIfAbsent(user.getId(), user) == null;
    }

    @Override
    public boolean removeMember(int id){
        return members.remove(id) != null;
    }

    @Override
    public boolean findMember(int id){
        return members.containsKey(id);
    }

    public User findMember(String name){
        for (User member : members.values()) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    //transaction
    @Override
    public boolean addTransaction(Transaction trans){
        return transactions.add(trans);
    }

    @Override
    public boolean removeTransaction(Transaction trans){
        return transactions.remove(trans);
    }

    @Override
    public boolean findTransaction(Transaction trans){
        return transactions.contains(trans);
    }

    //output list
    @Override
    public ArrayList<Book> getBooksList() {
        return new ArrayList<>(books.values());
    }

    @Override
    public ArrayList<User> getMembersList() {
        return new ArrayList<>(members.values());
    }

    @Override
    public ArrayList<Transaction> getTransactionsList() {
        return transactions;
    }    
}
