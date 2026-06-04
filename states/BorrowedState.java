package states;
import entity.Book;

public class BorrowedState implements BookState {
    
    @Override
    public boolean borrow(Book book) {
        // unable to borrow the book, since it's already borrowed
        return false;
    }

    @Override
    public boolean reserve(Book book) {
        // unable to reserve the book, since it's already borrowed
        return false;
    }

    @Override
    public boolean returnBook(Book book) {
        // set state to Available, and save transaction to database
        book.setState(new AvailableState());
        return true;
    }

    @Override
    public String getState() {
        return "Borrowed";
    }

}