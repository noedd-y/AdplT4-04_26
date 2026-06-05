package command;
import entity.*;
import facade.LibraryFacade;

//concrete command for borrowing a book, implements Command interface
public class BorrowBookCommand implements CommandInterface {
    private LibraryFacade libraryFacade;
    private String bookTitle;
    private User user;
    public BorrowBookCommand(LibraryFacade libraryFacade, String bookTitle, User user) {
        this.libraryFacade = libraryFacade;
        this.bookTitle = bookTitle;
        this.user = user;
    }

    @Override
    public void execute() {
        String result = libraryFacade.borrowBook(bookTitle, user);
        System.out.println(result);
    }
    
    @Override
    public boolean undo() {
        return false; // unable to undo a borrow operation, since it may have side effects on the book's state and user's borrowing history
    }
}
