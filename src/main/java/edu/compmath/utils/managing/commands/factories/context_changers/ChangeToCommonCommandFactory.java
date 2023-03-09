package edu.compmath.utils.managing.commands.factories.context_changers;

import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.CommandFactory;
import edu.compmath.utils.managing.CommandManagerContext;
import edu.compmath.utils.managing.commands.implementations.context_changers.ChangeToCommonCommand;

import java.util.Map;

public class ChangeToCommonCommandFactory extends CommandFactory {
    private final CommandManagerContext commandManagerContext;


    public ChangeToCommonCommandFactory(CommandManagerContext commandManagerContext) {
        this.commandManagerContext = commandManagerContext;
        this.commandExample = new ChangeToCommonCommand(null);
    }

    @Override
    public Command createCommand() {
        return new ChangeToCommonCommand(commandManagerContext);
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
