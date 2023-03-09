package edu.compmath.utils.interaction;

import edu.compmath.Main;
import edu.compmath.utils.Strategy;
import edu.compmath.utils.io.Reader;
import edu.compmath.utils.io.Writer;
import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.parsers.implementations.StringPrettifyParser;

import java.io.IOException;

public abstract class InteractionStrategy implements Strategy {
    protected final CommandScanner commandScanner;

    public InteractionStrategy(CommandScanner commandScanner) {
        this.commandScanner = commandScanner;
    }

    @Override
    public void execute() {
        Main.setCommandScanner(this.commandScanner);
    }

}
