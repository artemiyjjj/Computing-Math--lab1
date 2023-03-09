package edu.compmath.utils.interaction.console;

import edu.compmath.Main;
import edu.compmath.utils.interaction.InteractionStrategy;
import edu.compmath.utils.io.readers.ConsoleReader;
import edu.compmath.utils.io.writers.ConsoleWriter;

import java.io.IOException;

public class ConsoleInteractionStrategy extends InteractionStrategy {

    public ConsoleInteractionStrategy() {
        super(new ConsoleScanner());
        Main.setReader(new ConsoleReader(System.in));
        Main.setWriter(new ConsoleWriter());
    }

}
