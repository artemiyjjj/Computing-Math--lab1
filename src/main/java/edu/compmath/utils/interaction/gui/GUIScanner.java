package edu.compmath.utils.interaction.gui;

import edu.compmath.utils.interaction.CommandScanner;
import edu.compmath.utils.io.Reader;

import java.io.IOException;

public class GUIScanner implements CommandScanner {
    private Reader reader;
    public GUIScanner(Reader reader) {
        this.reader = reader;
    }
    @Override
    public String scan() throws IOException {
        return reader.read();
    }
}
