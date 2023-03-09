package edu.compmath.utils.parsers.implementations;

import edu.compmath.utils.exceptions.InvalidCommandArgsException;
import edu.compmath.utils.exceptions.InvalidCommandNameException;
import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.managers.CommandManager;
import edu.compmath.utils.parsers.CommandParser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class ConsoleCommandParser implements CommandParser {

    public ConsoleCommandParser() {
    }

    public Command parseCommand(String commandName, CommandManager commandManager) throws InvalidCommandNameException {
        Command searchedCommand = commandManager.getCommand(commandName);

        if (searchedCommand == null) {
            throw new InvalidCommandNameException("There is no such command :(");
        } else {
            return searchedCommand;
        }
    }

    public String[] parseArguments(String commandName, String[] args, CommandManager commandManager) throws InvalidCommandArgsException {
        String[] registeredArgs = commandManager.getRegisteredCommandArguments(commandName);
        String[] validatedArgs = validateArgs(args, registeredArgs);

        return validatedArgs;
    }

    private String[] validateArgs(String[] args, String[] acceptableArgs) throws InvalidCommandArgsException {
        if (args.length == 0) {
            return args;
        }
        if (acceptableArgs.length == 0) {
            throw new InvalidCommandArgsException("This command doesn't have any arguments.");
        }
        String[] splitArgs = splitArgs(args);
        Set<String> validatedArgsSet = new HashSet<>();
        for (var arg : splitArgs) {
            for (var acceptableArg : acceptableArgs) {
                if (arg.equals(acceptableArg)) {
                    validatedArgsSet.add(arg);
                } else {
                    throw new InvalidCommandArgsException("Some arguments are not valid.");
                }
            }
        }
        return validatedArgsSet.toArray(String[]::new);
    }

    private String[] splitArgs(String[] args) {
        return Arrays.stream(args).
//                 there can be added "--" command arguments regex
//                flatMap(Pattern.compile("-[A-Za-z]{1} ")::splitAsStream).
//                flatMap(Pattern.compile("")::splitAsStream).
        toArray(String[]::new);
    }
}
