package edu.compmath.utils.io.readers;

import edu.compmath.utils.io.Reader;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReader extends Reader {

    public FileReader(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public String read() throws IOException {
        int temp;
        StringBuilder readString = new StringBuilder();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(this.inputStream)) {
            while ((temp = bufferedInputStream.read()) != -1) {
                readString.append((char) temp);
            }
        }
        return readString.toString();
    }

}
