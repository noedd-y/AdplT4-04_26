package command;
import entity.*;
import facade.LibraryFacade;

//concrete command for borrowing a book, implements Command interface
public class BorrowBookCommand implements CommandInterface {
    private LibraryFacade libraryFacade;
    private Book book;
    private User user;
    public BorrowBookCommand(LibraryFacade libraryFacade, Book book, User user) {
        this.libraryFacade = libraryFacade;
        this.book = book;
        this.user = user;
    }

    @Override
    public void execute() {
        String result = libraryFacade.borrowBook(book, user);
        System.out.println(result);
    }
    
    @Override
    public boolean undo() {
        return false; // unable to undo a borrow operation, since it may have side effects on the book's state and user's borrowing history
    }
}
