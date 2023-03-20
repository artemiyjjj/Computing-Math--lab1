package edu.compmath.utils.managing.commands.factories.context_changers;

import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.CommandFactory;
import edu.compmath.utils.managing.CommandManagerContext;
import edu.compmath.utils.managing.commands.implementations.context_changers.ChangeToLinearAlgebraCommand;

import java.util.Map;

public class ChangeToLinearAlgebraCommandFactory extends CommandFactory {
    private final CommandManagerContext commandManagerContext;

    public ChangeToLinearAlgebraCommandFactory(CommandManagerContext commandManagerContext) {
        this.commandManagerContext = commandManagerContext;
        this.commandExample = new ChangeToLinearAlgebraCommand(null);
    }
    @Override
    public Command create() {
        return new ChangeToLinearAlgebraCommand(commandManagerContext);
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
