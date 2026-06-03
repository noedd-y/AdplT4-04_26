package State;

class BrokenState implements BookState {

    @Override
    public boolean borrow() {
        // unable to borrow the book, since it's already broken
        return false;
    }

    @Override
    public boolean reserve() {
        // unable to reserve the book, since it's already broken
        return false;
    }

    @Override
    public boolean returnBook() {
        // unable to return the book, since it's already broken
        return false;
    }

    @Override
    public String getState() {
        return "Broken";
    }

}