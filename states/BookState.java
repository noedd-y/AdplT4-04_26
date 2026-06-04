package states;
import entity.Book;

public interface BookState {
    boolean borrow(Book book);
    boolean returnBook(Book book);
    boolean reserve(Book book);
    boolean cancelReservation(Book book);

    String getState();
}