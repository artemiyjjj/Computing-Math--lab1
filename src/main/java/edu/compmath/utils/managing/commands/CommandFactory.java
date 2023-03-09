package edu.compmath.utils.managing.commands;

import java.util.Map;

public abstract class CommandFactory {
    protected Command commandExample;
    public abstract Command createCommand();
    public abstract String getCommandName();
    public abstract String getCommandDescription();
    public abstract Map<String, String> getCommandAcceptableArgs();

}
