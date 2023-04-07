package edu.compmath.utils.managing;

import edu.compmath.Main;
import edu.compmath.utils.Observer;
import edu.compmath.utils.exceptions.InvalidCommandArgsException;
import edu.compmath.utils.exceptions.InvalidCommandNameException;
import edu.compmath.utils.io.Writer;
import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.managers.CommandManager;
import edu.compmath.utils.parsers.CommandParser;
import edu.compmath.utils.parsers.implementations.ConsoleCommandParser;

import java.util.Arrays;

/** Object that parses commands name and args and if certain command manager contains them, it gets commands from c
 *
 */
public class Invoker implements Observer<String, CommandManager> {
    private CommandManager commandManager;
    private final CommandParser commandParser = new ConsoleCommandParser();

    public Invoker() {}

    public Invoker(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public void findAndExecuteCommand(String name, String[] params){
        Writer writer = Main.getWriter();
        try {
            Command command = commandParser.parseCommand(name, commandManager);
            String[] validatedParams = commandParser.parseArguments(name, params, commandManager);
            command.execute(validatedParams);
        } catch (InvalidCommandNameException | InvalidCommandArgsException e) {
            writer.write(e.getMessage());
            commandManager.getCommand("help").execute(new String[0]);
        }
    }

    @Override
    public void notifyOfUpdate(CommandManager[] commandManagers) {
        if (commandManagers.length == 1) {
            this.commandManager = commandManagers[0];
        }
    }

    @Override
    public void notifyOfExecution(String[] nameAndArgs) {
        String name = nameAndArgs[0];
        String[] args = Arrays.copyOfRange(nameAndArgs, 1, nameAndArgs.length);
        findAndExecuteCommand(name, args);
    }
}
