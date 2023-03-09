package edu.compmath.utils.managing.commands.factories.common;

import edu.compmath.utils.interaction.InteractionContext;
import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.CommandFactory;
import edu.compmath.utils.managing.commands.implementations.common.InteractionModeCommand;

import java.util.Map;

public class InteractionModeCommandFactory extends CommandFactory {

    public InteractionModeCommandFactory() {
        this.commandExample = new InteractionModeCommand();
    }

    @Override
    public Command createCommand() {
        return new InteractionModeCommand();
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
