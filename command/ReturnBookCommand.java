package command;
import entity.*;
import facade.LibraryFacade;

//concrete command for returning a book, implements Command interface
public class ReturnBookCommand implements CommandInterface {
    private LibraryFacade libraryFacade;
    private Book book;
    private User user;
    public ReturnBookCommand(LibraryFacade libraryFacade, Book book, User user) {
        this.libraryFacade = libraryFacade;
        this.book = book;
        this.user = user;
    }

    @Override
    public void execute() {
        String result = libraryFacade.returnBook(book, user);
        System.out.println(result);
    }

    @Override
    public boolean undo() {
        //extend undo to re-borrow the book after returning it
        String result = libraryFacade.borrowBook(book, user);
        System.out.println(result);
        return true;
    }
    
}
