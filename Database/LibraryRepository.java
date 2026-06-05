package database;

import entity.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface LibraryRepository {
    boolean addBook(Book book);
    boolean addMember(User member);
    boolean addTransaction(Transaction transaction);

    boolean removeBook(int id);
    boolean removeMember(int id);
    boolean removeTransaction(Transaction transaction);

    boolean findBook(int id);
    Book findBookByTitle(String title);
    List<Book> findBookByCategory(String category);
    List<Book> findBookByPublishedDate(LocalDate date);

    boolean findMember(int id);
    User findMember(String name);
    boolean findTransaction(Transaction transaction);

    ArrayList<Book> getBooksList();
    ArrayList<User> getMembersList();
    ArrayList<Transaction> getTransactionsList();

}
