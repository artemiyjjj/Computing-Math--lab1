package edu.compmath.utils.io;

import java.io.IOException;
import java.io.InputStream;

public abstract class Reader {
     protected final InputStream inputStream;

     public Reader() {
          this.inputStream = null;
     }

     public Reader(InputStream inputStream) {
          this.inputStream = inputStream;
     }

     public abstract String read() throws IOException;
     public void close() throws IOException {
          if (inputStream != null) {
               inputStream.close();
          }
     }
}
