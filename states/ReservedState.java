package states;
import entity.Book;

public class ReservedState implements BookStateInterface {
    
    @Override
    public boolean borrow(Book book) {
        // unable to borrow the book, since it's already reserved
        return false;
    }

    @Override
    public boolean reserve(Book book) {
        // unable to reserve the book, since it's already reserved
        return false;
    }

    @Override
    public boolean returnBook(Book book) {
        // unable to return the book, since its not yet borrowed
        return false;
    }

    @Override
    public boolean cancelReservation(Book book) {
        // able to cancel reservation, since the book is reserved
        book.setState(new AvailableState());
        return true;
    }   

    @Override
    public String getState() {
        return "Reserved";
    }

}