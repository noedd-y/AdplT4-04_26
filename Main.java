import command.CommandManager;
import database.LibraryDatabase;
import database.LibraryRepository;
import facade.LibraryFacade;

public class Main {
    public static void main(String[] args) {
        LibraryRepository repository = LibraryDatabase.getInstance();
        LibraryFacade facade = new LibraryFacade(repository);
        CommandManager cmd = new CommandManager();

    }
}
