package edu.compmath.utils.managing.commands.implementations.context_changers;

import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.CommandManagerContext;
import edu.compmath.utils.managing.commands.managers.CommonCommandStrategy;

import java.util.HashMap;
import java.util.Map;

public class ChangeToCommonCommand extends Command {
    private final static String name = "common commands";
    private final static String description = "command returns you to the main menu.";
    private final static Map<String, String> acceptableArgs = new HashMap<>();
    private final CommandManagerContext commandManagerContext;

    public ChangeToCommonCommand(CommandManagerContext commandManagerContext) {
        this.commandManagerContext = commandManagerContext;
    }

    @Override
    public void execute(String[] args) {
        commandManagerContext.changeStrategy(CommonCommandStrategy.class);
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
