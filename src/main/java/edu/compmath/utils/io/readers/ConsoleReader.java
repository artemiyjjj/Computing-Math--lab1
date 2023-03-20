package edu.compmath.utils.io.readers;

import edu.compmath.utils.io.Reader;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ConsoleReader extends Reader {


    public ConsoleReader(InputStream inputStream) {
        super(new BufferedInputStream(inputStream));
    }

    @Override
    public String read() throws IOException {
        char temp;
        StringBuilder readString = new StringBuilder();
        while ((temp = (char) inputStream.read()) != '\n') {
            readString.append(temp);
        }

        return readString.toString();
    }
}
