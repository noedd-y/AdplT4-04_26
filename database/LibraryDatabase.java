package database;
import entity.*;
import java.util.ArrayList;

public class LibraryDatabase {
    private static LibraryDatabase instance;

    private ArrayList<Book> books;
    private ArrayList<User> members;
    private ArrayList<Transaction> transactions;

    public LibraryDatabase() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
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
    public boolean addBook(Book target){
        if (!findBook(target)) {
            return books.add(target);
        }
        return false;
    }

    public boolean removeBook(Book target){
        return books.remove(target);
    }

    public boolean findBook(Book target){
        return books.contains(target);
    }
    
    public boolean addMember(User user){
        if (!findMember(user)) {
            return members.add(user);
        }
        return false;
    }

    public boolean findMember(User user){
        return members.contains(user);
    }

    public boolean saveTransaction(Transaction trans){
        return transactions.add(trans);
    }

    public ArrayList<Book> getBooksList() {
        return books;
    }

    public ArrayList<User> getMembersList() {
        return members;
    }

    public ArrayList<Transaction> getTransactionsList() {
        return transactions;
    }

    
}
