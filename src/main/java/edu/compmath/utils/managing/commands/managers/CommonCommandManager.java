package edu.compmath.utils.managing.commands.managers;

import edu.compmath.utils.interaction.InteractionContext;
import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.CommandFactory;
import edu.compmath.utils.managing.commands.factories.common.ExitCommandFactory;
import edu.compmath.utils.managing.commands.factories.common.HelpCommandFactory;
import edu.compmath.utils.managing.commands.factories.common.InteractionModeCommandFactory;

public class CommonCommandManager extends CommandManager {

    public CommonCommandManager() {
        super();
        CommandFactory[] commands = new CommandFactory[]{
                new ExitCommandFactory(),
                new HelpCommandFactory(this),
                new InteractionModeCommandFactory()
        };
        registerCommands(commands);
    }



}
