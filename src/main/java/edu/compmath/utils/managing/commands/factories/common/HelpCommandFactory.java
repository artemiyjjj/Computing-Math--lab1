package edu.compmath.utils.managing.commands.factories.common;

import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.CommandFactory;
import edu.compmath.utils.managing.commands.implementations.common.ExitCommand;
import edu.compmath.utils.managing.commands.implementations.common.HelpCommand;
import edu.compmath.utils.managing.commands.managers.CommandManager;

import java.util.Map;

public class HelpCommandFactory extends CommandFactory {
    private final CommandManager commandManager;

    public HelpCommandFactory(CommandManager commandManager) {
        this.commandManager = commandManager;

        this.commandExample = new HelpCommand(null);
    }
    @Override
    public Command createCommand() {
        return new HelpCommand(this.commandManager);
    }

    @Override
    public String getCommandName() {
        return this.commandExample.getName();
    }

    @Override
    public String getCommandDescription() {
        return this.commandExample.getDescription();
    }

    @Override
    public Map<String, String> getCommandAcceptableArgs() {
        return this.commandExample.getAcceptableArgs();
    }
}
