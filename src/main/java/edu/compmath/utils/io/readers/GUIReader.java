package edu.compmath.utils.io.readers;

import edu.compmath.utils.io.Reader;

import javax.swing.text.JTextComponent;
import java.io.IOException;

public class GUIReader extends Reader {
    private final JTextComponent input;

    public GUIReader(JTextComponent input) {
        this.input = input;
    }

    @Override
    public String read() throws IOException {
        return input.getText();
    }
}
