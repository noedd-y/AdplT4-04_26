package command;
import entity.*;
import facade.LibraryFacade;

//concrete command for returning a book, implements Command interface
public class ReturnBookCommand implements CommandInterface {
    private LibraryFacade libraryFacade;
    private String bookTitle;
    private User user;
    public ReturnBookCommand(LibraryFacade libraryFacade, String bookTitle, User user) {
        this.libraryFacade = libraryFacade;
        this.bookTitle = bookTitle;
        this.user = user;
    }

    @Override
    public void execute() {
        String result = libraryFacade.returnBook(bookTitle, user);
        System.out.println(result);
    }

    @Override
    public boolean undo() {
        //extend undo to re-borrow the book after returning it
        String result = libraryFacade.borrowBook(bookTitle, user);
        System.out.println(result);
        return true;
    }
    
}
