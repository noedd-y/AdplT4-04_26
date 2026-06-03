package State;

class AvailableState implements BookState {

    @Override
    public boolean borrow() {
        // able to borrow the book, change state to Borrowed
        // make transaction, save to database, and change state to Borrowed
        return true;
    }

    @Override
    public boolean reserve() {
        // able to reserve the book, change state to Reserved
        return true;
    }

    @Override
    public boolean returnBook() {
        // unable to return the book, since it's already available
        return false;
    }

    @Override
    public String getState() {
        return "Available";
    }
}