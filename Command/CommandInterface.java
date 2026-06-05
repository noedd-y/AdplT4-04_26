package command;
//command interface for library operations, receiver is LibraryFacade
public interface CommandInterface {
    void execute();
    boolean undo(); 
} 

