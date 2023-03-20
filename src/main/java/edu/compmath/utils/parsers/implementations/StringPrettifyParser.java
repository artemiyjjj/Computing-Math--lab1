package edu.compmath.utils.parsers.implementations;

public class StringPrettifyParser {
    public static String[] handleLine(String line) {
        String[] splitLine = line.split(",[ ]+|[ ]+");
        return handleLine(splitLine);
    }

    public static String[] handleLine(String[] array) {
        String[] trimmedLine = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            trimmedLine[i] = array[i].trim();
        }
        return trimmedLine;
    }
}
