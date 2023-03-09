package edu.compmath.utils.parsers;

import edu.compmath.utils.exceptions.InvalidCommandArgsException;

public interface ArgumentParser<T> {
    T argumentParse(String[] args) throws InvalidCommandArgsException;
}
