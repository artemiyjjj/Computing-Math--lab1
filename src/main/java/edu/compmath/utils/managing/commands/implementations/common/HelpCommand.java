package edu.compmath.utils.managing.commands.implementations.common;

import edu.compmath.Main;
import edu.compmath.utils.io.Writer;
import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.CommandFactory;
import edu.compmath.utils.managing.commands.managers.CommandManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HelpCommand extends Command {
    private final static String name = "help";
    private final static String description = "command shows list of commands which user can execute.";
    private final static Map<String, String> acceptableArgs = new HashMap<>();
    private final CommandManager commandManager;

    public HelpCommand(CommandManager commandManager)  {
        this.commandManager = commandManager;
    }

    public void execute(String[] args) {
        Writer writer = Main.getWriter();
        int i = 0;
        Map<String, CommandFactory> registeredCommands = commandManager.getRegisteredCommandFactories();
        for (Map.Entry<String, CommandFactory> entryCommands : registeredCommands.entrySet()) {
            writer.write("\t" + i + ": " + entryCommands.getKey() + " — " + entryCommands.getValue().getCommandDescription());
            i++;
            if (entryCommands.getValue().getCommandAcceptableArgs().size() != 0) {
                Map<String, String> registeredArgs = entryCommands.getValue().getCommandAcceptableArgs();
                for (Map.Entry<String, String> entryArgs : registeredArgs.entrySet()) {
                    writer.write("\t\t-" + entryArgs.getKey() + " — " + entryArgs.getKey());
                }
            }
        }
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
