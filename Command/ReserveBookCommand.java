package Command;
import Entity.*;
import Library.LibraryFacade;

//concrete command for reserving a book, implements Command interface
public class ReserveBookCommand implements Command {
    private LibraryFacade libraryFacade;
    private Book book;
    private User user;
    private String transactionDate;
    private String returnDate;
    public ReserveBookCommand(LibraryFacade libraryFacade, Book book, User user, String transactionDate, String returnDate) {
        this.libraryFacade = libraryFacade;
        this.book = book;
        this.user = user;
        this.transactionDate = transactionDate;
        this.returnDate = returnDate;
    }

    @Override
    public void execute() {
        String result = libraryFacade.reserveBook(book, user, transactionDate, returnDate);
        System.out.println(result);
    }
    
}
