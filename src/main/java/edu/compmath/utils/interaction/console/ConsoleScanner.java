package edu.compmath.utils.interaction.console;

import edu.compmath.Main;
import edu.compmath.utils.interaction.CommandScanner;

import java.io.IOException;

public class ConsoleScanner implements CommandScanner {
    @Override
    public String scan() throws IOException {
        return Main.getReader().read();
    }
}
