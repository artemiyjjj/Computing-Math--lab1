package edu.compmath.utils.managing.commands;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public abstract class Command implements Serializable {
    protected String[] args;

    public Command() {}

    public abstract void execute(String[] args);

    public abstract String getName();

    public abstract String getDescription();

    /**
     *
     * @return Map of key String - command argument look for user, value String - description for help command and e.t.c
     */
    public abstract Map<String, String> getAcceptableArgs();


    public String[] getArgs() {
        return args;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Command)) return false;
        Command command = (Command) o;
        return getName().equals(command.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

}
