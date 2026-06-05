package states;
import entity.Book;

public class BorrowedState implements BookStateInterface {
    
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
    public boolean cancelReservation(Book book) {
        // unable to cancel reservation, since the book is not reserved
        return false;
    }   

    @Override
    public String getState() {
        return "Borrowed";
    }

}