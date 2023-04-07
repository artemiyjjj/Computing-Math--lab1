package edu.compmath.utils.parsers.implementations;

import edu.compmath.math_section.linear_algebra.methods.gauss_seidel.utils.Precision;
import edu.compmath.utils.exceptions.InvalidCommandArgsException;
import edu.compmath.utils.parsers.ArgumentParser;

public class PrecisionParser implements ArgumentParser<Precision<Double>> {
    @Override
    public Precision<Double> argumentParse(String[] args) throws InvalidCommandArgsException {
        if (args.length != 1) {
            throw new InvalidCommandArgsException("Amount of arguments must be 1.");
        }
        double value;
        try {
            value = Double.parseDouble(args[0]);
        } catch (ClassCastException | NumberFormatException e) {
            throw new InvalidCommandArgsException("Precision must be float value.");
        }
        return new Precision<>(value);
    }
}
