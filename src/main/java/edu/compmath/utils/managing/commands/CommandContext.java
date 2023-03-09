package edu.compmath.utils.managing.commands;


import edu.compmath.utils.Context;

public abstract class CommandContext extends Context {
    public CommandContext(CommandStrategy commandStrategy) {
        super(commandStrategy);
    }

}
