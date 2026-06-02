import java.lang.reflect.Member;
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
    private ArrayList<Member> members;
    private ArrayList<Transaction> transactions;

    void addBook(Book target){
        books.add(target);
    }

    boolean removeBook(Book target){
        return books.remove(target);
    }

    boolean findBook(Book target){
        return books.contains(target);
    }
    
    void addMember(Member user){
        members.add(user);
    }

    void saveTransaction(Transaction trans){
        transactions.add(trans);
    }
}
