package states;
import entity.Book;

public class BrokenState implements BookState {

    @Override
    public boolean borrow(Book book) {
        // unable to borrow the book, since it's already broken
        return false;
    }

    @Override
    public boolean reserve(Book book) {
        // unable to reserve the book, since it's already broken
        return false;
    }

    @Override
    public boolean returnBook(Book book) {
        // unable to return the book, since it's already broken
        return false;
    }

    @Override
    public boolean cancelReservation(Book book) {
        // unable to cancel reservation, since the book is not reserved
        return false;
    }   

    @Override
    public String getState() {
        return "Broken";
    }

}