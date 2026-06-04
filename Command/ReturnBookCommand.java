package command;
import entity.*;
import facade.LibraryFacade;

//concrete command for returning a book, implements Command interface
public class ReturnBookCommand implements Command {
    private LibraryFacade libraryFacade;
    private Book book;
    private User user;
    private String transactionDate;
    private String returnDate;
    public ReturnBookCommand(LibraryFacade libraryFacade, Book book, User user, String transactionDate, String returnDate) {
        this.libraryFacade = libraryFacade;
        this.book = book;
        this.user = user;
        this.transactionDate = transactionDate;
        this.returnDate = returnDate;
    }

    @Override
    public void execute() {
        String result = libraryFacade.returnBook(book, user);
        System.out.println(result);
    }
    
}
