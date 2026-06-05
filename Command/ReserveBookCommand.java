package command;
import entity.*;
import facade.LibraryFacade;

//concrete command for reserving a book, implements Command interface
public class ReserveBookCommand implements CommandInterface {
    private LibraryFacade libraryFacade;
    private String bookTitle;
    private User user;
    public ReserveBookCommand(LibraryFacade libraryFacade, String bookTitle, User user) {
        this.libraryFacade = libraryFacade;
        this.bookTitle = bookTitle;
        this.user = user;
    }

    @Override
    public void execute() {
        String result = libraryFacade.reserveBook(bookTitle, user);
        System.out.println(result);
    }

    @Override
    public boolean undo() {
        String result = libraryFacade.cancelReservation(bookTitle, user);
        System.out.println(result);
        return true;
    }
    
}
