package edu.compmath.utils;

import java.io.IOException;

public abstract class Context{
    protected Strategy strategy;

    protected Context() {}

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy() throws IOException {
        this.strategy.execute();
    }
}
