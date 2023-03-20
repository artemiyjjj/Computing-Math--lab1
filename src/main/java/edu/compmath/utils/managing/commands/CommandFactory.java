package edu.compmath.utils.managing.commands;

import edu.compmath.utils.Factory;

import java.util.Map;

public abstract class CommandFactory implements Factory<Command> {
    protected Command commandExample;
    public abstract Command create();
    public abstract String getCommandName();
    public abstract String getCommandDescription();
    public abstract Map<String, String> getCommandAcceptableArgs();

}
