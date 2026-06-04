package states;
import entity.Book;

public interface BookState {
    boolean borrow(Book book);
    boolean returnBook(Book book);
    boolean reserve(Book book);

    String getState();
}