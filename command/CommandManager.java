package command;

import java.util.Stack;

//invoker class that executes commands
public class CommandManager {
    private Stack<CommandInterface> commandHistory = new Stack<>();

    public void executeCommand(CommandInterface command) {
        command.execute();
        commandHistory.push(command);
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            CommandInterface lastCommand = commandHistory.pop();
            if (!lastCommand.undo()) {
                System.out.println("Failed to undo the last command.");
                commandHistory.push(lastCommand); // push it back since undo failed
            } else {
                System.out.println("Last command undone successfully.");
            }
        } else {
            System.out.println("No commands to undo.");
        }
    }
}
