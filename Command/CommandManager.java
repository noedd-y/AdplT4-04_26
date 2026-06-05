package command;

import java.util.Stack;

//invoker class that executes commands
public class CommandManager {
    private Stack<Command> commandHistory = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
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
