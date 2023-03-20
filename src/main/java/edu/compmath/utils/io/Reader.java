package edu.compmath.utils.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

public abstract class Reader {
     protected final InputStream inputStream;

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
