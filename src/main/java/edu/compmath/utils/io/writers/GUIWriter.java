package edu.compmath.utils.io.writers;

import edu.compmath.utils.io.Writer;

import javax.swing.JComponent;


public class GUIWriter implements Writer {
    private final JComponent component;

    public GUIWriter(JComponent component) {
        this.component = component;
    }

    @Override
    public void write(String string) {

    }

    @Override
    public void writeErr(String string) {

    }

    public JComponent getComponent() {
        return component;
    }
}
