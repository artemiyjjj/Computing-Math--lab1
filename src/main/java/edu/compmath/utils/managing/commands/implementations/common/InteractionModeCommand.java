package edu.compmath.utils.managing.commands.implementations.common;

import edu.compmath.Main;
import edu.compmath.utils.interaction.InteractionContext;
import edu.compmath.utils.interaction.console.ConsoleInteractionStrategy;
import edu.compmath.utils.interaction.gui.GUIInteractionStrategy;
import edu.compmath.utils.managing.commands.Command;

import java.util.HashMap;
import java.util.Map;

public class InteractionModeCommand extends Command {
    private final static String name = "changeView";
    private final static String description = "command changes the user interface type from console to window mode and vice-versa.";
    private final static Map<String, String> acceptableArgs = new HashMap<>();
    static {
        acceptableArgs.put("c", "change to console interface.");
        acceptableArgs.put("g", "change to graphical user interface.");
    }

    public InteractionModeCommand(){}

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            if (Main.getInteractionContext().getInteractionStrategy() instanceof ConsoleInteractionStrategy) {
                setGUIStrategy();
            } else {
                setConsoleStrategy();
            }
        } else {
            switch (args[0]) {
                case "c": {
                    if (Main.getInteractionContext().getInteractionStrategy() instanceof ConsoleInteractionStrategy) {
                        Main.getWriter().writeErr("Console interface is already on.");
                    } else {
                        setGUIStrategy();
                    }
                }
                case "g": {
                    if (Main.getInteractionContext().getInteractionStrategy() instanceof GUIInteractionStrategy) {
                        Main.getWriter().writeErr("GUI interface is already on.");
                    } else {
                        setConsoleStrategy();
                    }
                }
            }
        }
    }

    private void setConsoleStrategy() {
        Main.changeInteractionContext(ConsoleInteractionStrategy.class);
    }

    private void setGUIStrategy() {
        Main.changeInteractionContext(GUIInteractionStrategy.class);
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
