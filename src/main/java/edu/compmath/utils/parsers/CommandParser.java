package edu.compmath.utils.parsers;

import edu.compmath.utils.managing.commands.managers.CommandManager;
import edu.compmath.utils.managing.commands.Command;

public interface CommandParser {
    Command parseCommand(String commandName, CommandManager commandManager);
    String[] parseArguments(String commandName, String[] args, CommandManager commandManager);
}
