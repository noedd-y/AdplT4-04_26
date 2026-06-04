package Database;
import java.util.ArrayList;

import Entity.Book;
import Entity.Transaction;
import Entity.User;

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
    public void addBook(Book target){
        books.add(target);
    }

    public boolean removeBook(Book target){
        return books.remove(target);
    }

    public boolean findBook(Book target){
        return books.contains(target);
    }
    
    public void addMember(User user){
        members.add(user);
    }

    public void saveTransaction(Transaction trans){
        transactions.add(trans);
    }
}
