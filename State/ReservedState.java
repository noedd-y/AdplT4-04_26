package State;

class ReservedState implements BookState {
    
    @Override
    public boolean borrow() {
        // unable to borrow the book, since it's already reserved
        return false;
    }

    @Override
    public boolean reserve() {
        // unable to reserve the book, since it's already reserved
        return false;
    }

    @Override
    public boolean returnBook() {
        // unable to return the book, since its not yet borrowed
        return false;
    }

    @Override
    public String getState() {
        return "Reserved";
    }

}