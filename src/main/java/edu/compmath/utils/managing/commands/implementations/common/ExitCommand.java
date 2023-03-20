package edu.compmath.utils.managing.commands.implementations.common;

import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.managers.CommandManager;

import java.util.HashMap;
import java.util.Map;

public class ExitCommand extends Command {
    private final static String name = "exit";
    private final static String description = "command stops program's executing.";
    private final static Map<String, String> acceptableArgs = new HashMap<>();

    @Override
    public void execute(String[] args) {
        System.exit(0);
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
