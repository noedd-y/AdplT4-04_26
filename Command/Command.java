package command;
//command interface for library operations, receiver is LibraryFacade
public interface Command {
    void execute();
    boolean undo(); 
} 

