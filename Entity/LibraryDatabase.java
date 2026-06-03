package Entity;
import java.util.ArrayList;

public class LibraryDatabase {
    private static LibraryDatabase instance;

    //singleton
    public static LibraryDatabase getInstance() {
        if (instance == null) {
            instance = new LibraryDatabase();
        }
        return instance;
    }

    private ArrayList<Book> books;
    private ArrayList<User> members;
    private ArrayList<Transaction> transactions;

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
