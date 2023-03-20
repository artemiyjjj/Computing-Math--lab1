package edu.compmath.utils.managing.commands.implementations.context_changers;

import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.CommandManagerContext;
import edu.compmath.utils.managing.commands.managers.LinearAlgebraCommandStrategy;

import java.util.HashMap;
import java.util.Map;

public class ChangeToLinearAlgebraCommand<T extends LinearAlgebraCommandStrategy> extends Command {
    private final static String name = "linear_algebra_commands";
    private final static String description = "command shows you menu with linear algebra commands.";
    private final static Map<String, String> acceptableArgs = new HashMap<>();
    private final CommandManagerContext commandManagerContext;

    public ChangeToLinearAlgebraCommand(CommandManagerContext commandManagerContext) {
        this.commandManagerContext = commandManagerContext;
    }

    @Override
    public void execute(String[] args) {
        this.commandManagerContext.changeStrategy(LinearAlgebraCommandStrategy.class);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Map<String, String> getAcceptableArgs() {
        return acceptableArgs;
    }
}
