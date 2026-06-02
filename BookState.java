public interface BookState {
    void borrow();
    void returnBook();
    void reserve();

    String getState();
}

class AvailableState implements BookState {

    @Override
    public void borrow() {
        // able to borrow the book, change state to Borrowed
        // make transaction, save to database, and change state to Borrowed
    }

    @Override
    public void reserve() {
        // able to reserve the book, change state to Reserved
        
    }

    @Override
    public void returnBook() {
        // unable to return the book, since it's already available
        
    }

    @Override
    public String getState() {
        return "Available";
    }
}

class BorrowedState implements BookState {
    
    @Override
    public void borrow() {
        // unable to borrow the book, since it's already borrowed
        
    }

    @Override
    public void reserve() {
        // unable to reserve the book, since it's already borrowed
        
    }

    @Override
    public void returnBook() {
        // set state to Available, and save transaction to database
        
    }

    @Override
    public String getState() {
        return "Borrowed";
    }

}

class ReservedState implements BookState {
    
    @Override
    public void borrow() {
        // unable to borrow the book, since it's already reserved
        
    }

    @Override
    public void reserve() {
        // unable to reserve the book, since it's already reserved
        
    }

    @Override
    public void returnBook() {
        // unable to return the book, since its not yet borrowed
        
    }

    @Override
    public String getState() {
        return "Reserved";
    }

}

class LostState implements BookState {

    
    @Override
    public void borrow() {
        // unable to borrow the book, since it's already lost
        
    }

    @Override
    public void reserve() {
        // unable to reserve the book, since it's already lost
        
    }

    @Override
    public void returnBook() {
        // unable to return the book, since it's already lost
        
    }

    @Override
    public String getState() {
        return "Lost";
    }

}