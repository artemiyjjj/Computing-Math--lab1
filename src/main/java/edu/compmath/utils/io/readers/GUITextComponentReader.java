package edu.compmath.utils.io.readers;

import javax.swing.text.JTextComponent;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class GUITextComponentReader extends GUIReader {
    private final JTextComponent input;

    public GUITextComponentReader(JTextComponent input) {
        //todo придумать как хранить text
        super(new ByteArrayInputStream(input.getText().getBytes()));
        this.input = input;
    }

    @Override
    public String read() throws IOException {
        return input.getText();
    }
}
