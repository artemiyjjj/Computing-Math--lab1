package edu.compmath.utils.managing.commands;


import edu.compmath.utils.Context;
import edu.compmath.utils.Strategy;

public abstract class CommandContext extends Context {
    public CommandContext(CommandStrategy commandStrategy) {
        super(commandStrategy);
    }
    public CommandContext() {}
    public void setStrategy(CommandStrategy strategy) {
        this.strategy = strategy;
    }

}
