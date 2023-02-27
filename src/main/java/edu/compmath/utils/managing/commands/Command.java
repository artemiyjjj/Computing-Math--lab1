package edu.compmath.utils.managing.commands;

import java.io.Serializable;
import java.util.Objects;

public abstract class Command implements Serializable {
    protected String[] args;

    protected Command(String name, String[] acceptableArgs, boolean hasArgs) {
//        CommandInfo(name, acceptableArgs, hasArgs);
    }

    public Command(String[] args) {
        this.args = args;
    }

    public abstract void execute();

    @Override
    public String toString() {
        return CommandInfo.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Command)) return false;
        Command command = (Command) o;
        return CommandInfo.name.equals(command.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(CommandInfo.name);
    }

    public abstract static class CommandInfo {
        private static String name;
        private static String[] acceptableArgs;
        private static boolean hasArgs;

        private CommandInfo() {}

        public CommandInfo(String name, String[] acceptableArgs, boolean hasArgs) {
            CommandInfo.name = name;
            CommandInfo.acceptableArgs = acceptableArgs;
            CommandInfo.hasArgs = hasArgs;
        }

        public static String getName() {
            return name;
        }

        public static String[] getAcceptableArgs() {
            return acceptableArgs;
        }

        public static boolean hasArgs() {
            return hasArgs;
        }
    }
}
