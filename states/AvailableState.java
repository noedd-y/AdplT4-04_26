package states;
import entity.Book;

public class AvailableState implements BookState {

    @Override
    public boolean borrow(Book book) {
        // able to borrow the book, change state to Borrowed
        // make transaction, save to database, and change state to Borrowed
        book.setState(new BorrowedState());
        return true;
    }

    @Override
    public boolean reserve(Book book) {
        // able to reserve the book, change state to Reserved
        book.setState(new ReservedState());
        return true;
    }

    @Override
    public boolean returnBook(Book book) {
        // unable to return the book, since it's already available
        return false;
    }

    @Override
    public String getState() {
        return "Available";
    }
}