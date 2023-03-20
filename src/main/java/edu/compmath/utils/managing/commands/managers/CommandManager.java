package edu.compmath.utils.managing.commands.managers;

import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.CommandFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CommandManager {
    protected final Map<String, CommandFactory> registeredCommands = new HashMap<>();;
    protected final Map<String, String[]> registeredCommandArguments = new HashMap<>();

    /**
     * Extending classes must use registerCommand or registerCommands methods in constructor to avoid misunderstandings
     */
    public CommandManager(CommandFactory[] commandFactories) {
        registerCommands(commandFactories);
        registerArguments();
    }

    public CommandManager() {}

    protected void registerCommands(CommandFactory[] commandFactories) {
        if (commandFactories.length > 0) {
            for (var commandFactory : commandFactories) {
                registerCommand(commandFactory);
            }
        }
    }

    protected void registerArguments() {
        for (var command : registeredCommands.values()) {
            registerArgument(command);
        }
    }

    protected void registerCommand(CommandFactory commandFactory) {
        if (registeredCommands.get(commandFactory.getCommandName()) == null) {
            this.registeredCommands.put(commandFactory.getCommandName(), commandFactory);
            registerArgument(commandFactory);
        }

    }

    protected void registerArgument(CommandFactory commandFactory) {
        if (!commandFactory.getCommandAcceptableArgs().isEmpty() && registeredCommandArguments.get(commandFactory.getCommandName()) == null) {
            List<String> argumentsList = new ArrayList<>();
            for (Map.Entry<String, String> argumentEntity: commandFactory.getCommandAcceptableArgs().entrySet()) {
                argumentsList.add(argumentEntity.getKey());
            }

            registeredCommandArguments.put(commandFactory.getCommandName(), argumentsList.toArray(String[]::new));
        }
    }


    public Map<String, CommandFactory> getRegisteredCommandFactories() {
        return this.registeredCommands;
    }

    public String[] getRegisteredCommandArguments(String commandName) {
        return this.registeredCommandArguments.get(commandName);
    }

    public Command getCommand(String commandName) {
        CommandFactory commandFactory = this.registeredCommands.get(commandName);
        return commandFactory != null ? commandFactory.create() : null;
    }

}
