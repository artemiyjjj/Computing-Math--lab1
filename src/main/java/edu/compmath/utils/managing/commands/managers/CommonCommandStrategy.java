package edu.compmath.utils.managing.commands.managers;

import edu.compmath.Main;
import edu.compmath.utils.managing.commands.CommandStrategy;
import edu.compmath.utils.managing.commands.factories.common.ExitCommandFactory;
import edu.compmath.utils.managing.commands.factories.common.HelpCommandFactory;
import edu.compmath.utils.managing.commands.factories.common.InteractionModeCommandFactory;
import edu.compmath.utils.parsers.implementations.StringPrettifyParser;

import java.io.IOException;

public class CommonCommandStrategy extends CommandStrategy {

    public CommonCommandStrategy() {
        super(new CommonCommandManager());
    }

    @Override
    public void execute() throws IOException {
        Main.getWriter().write("Common commands menu >>");
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
