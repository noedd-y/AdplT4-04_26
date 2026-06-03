public interface BookState {
    boolean borrow();
    boolean returnBook();
    boolean reserve();

    String getState();
}

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

class LostState implements BookState {

    
    @Override
    public boolean borrow() {
        // unable to borrow the book, since it's already lost
        return false;
    }

    @Override
    public boolean reserve() {
        // unable to reserve the book, since it's already lost
        return false;
    }

    @Override
    public boolean returnBook() {
        // unable to return the book, since it's already lost
        return false;
    }

    @Override
    public String getState() {
        return "Lost";
    }

}