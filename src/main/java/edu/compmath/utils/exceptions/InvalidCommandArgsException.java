package edu.compmath.utils.exceptions;

public class InvalidCommandArgsException extends RuntimeException {
    public InvalidCommandArgsException(String message) {
        super(message);
    }
}
