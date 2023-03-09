package edu.compmath.utils.managing.commands.factories.common;

import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.CommandFactory;
import edu.compmath.utils.managing.commands.implementations.common.ExitCommand;

import java.util.Map;

public class ExitCommandFactory extends CommandFactory {
    public ExitCommandFactory() {
        this.commandExample = new ExitCommand();
    }
    @Override
    public Command createCommand() {
        return new ExitCommand();
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
