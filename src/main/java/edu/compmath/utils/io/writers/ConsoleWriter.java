package edu.compmath.utils.io.writers;

import edu.compmath.utils.io.Writer;

import java.io.PrintStream;

public class ConsoleWriter implements Writer {
    protected PrintStream commonOutputStream;
    protected PrintStream errorOutputStream;
    public ConsoleWriter() {
        this.commonOutputStream = System.out;
        this.errorOutputStream = System.err;
    }

    @Override
    public void write(String string) {
        commonOutputStream.println(string);
    }

    public void write() {
        commonOutputStream.println();
    }

    @Override
    public void writeErr(String string) {
        errorOutputStream.println(string);
    }
}
