package edu.compmath.utils.managing.commands.managers;

import edu.compmath.Main;
import edu.compmath.utils.managing.CommandManagerContext;
import edu.compmath.utils.managing.commands.CommandStrategy;
import edu.compmath.utils.parsers.implementations.StringPrettifyParser;

import java.io.IOException;

public class CommonCommandStrategy extends CommandStrategy {

    public CommonCommandStrategy(CommandManagerContext commandManagerContext) {
        super(new CommonCommandManager(commandManagerContext));
    }

    @Override
    public void execute() throws IOException {
        Main.getWriter().write("\nCommon commands menu >>");
        Main.getWriter().write("Insert the command (\"help\" for example )");
        String commandScanResult = Main.getCommandScanner().scan();
        String[] formattedScanResult = StringPrettifyParser.handleLine(commandScanResult);
        observable.notifyObserversOfExecution(formattedScanResult);
    }

    @Override
    public CommandManager getCommandManager() {
        return this.commandManager;
    }
}
