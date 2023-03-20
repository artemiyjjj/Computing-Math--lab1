package edu.compmath.utils.io.readers;

import edu.compmath.utils.io.Reader;

import java.io.InputStream;

public abstract class GUIReader extends Reader {
    public GUIReader(InputStream inputStream) {
        super(inputStream);
    }
}
