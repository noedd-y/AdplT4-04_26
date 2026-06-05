package command;
import entity.*;
import facade.LibraryFacade;

//concrete command for reserving a book, implements Command interface
public class ReserveBookCommand implements Command {
    private LibraryFacade libraryFacade;
    private Book book;
    private User user;
    public ReserveBookCommand(LibraryFacade libraryFacade, Book book, User user) {
        this.libraryFacade = libraryFacade;
        this.book = book;
        this.user = user;
    }

    @Override
    public void execute() {
        String result = libraryFacade.reserveBook(book, user);
        System.out.println(result);
    }

    @Override
    public boolean undo() {
        String result = libraryFacade.cancelReservation(book, user);
        System.out.println(result);
        return true;
    }
    
}
