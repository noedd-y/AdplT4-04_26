package State;

class BorrowedState implements BookState {
    
    @Override
    public boolean borrow() {
        // unable to borrow the book, since it's already borrowed
        return false;
    }

    @Override
    public boolean reserve() {
        // unable to reserve the book, since it's already borrowed
        return false;
    }

    @Override
    public boolean returnBook() {
        // set state to Available, and save transaction to database
        return true;
    }

    @Override
    public String getState() {
        return "Borrowed";
    }

}