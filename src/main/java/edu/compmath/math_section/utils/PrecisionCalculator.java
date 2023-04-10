package edu.compmath.math_section.utils;

public class PrecisionCalculator<T extends Number> {
    public Precision<Double> calc(T newValue, T oldValue) {
        double difference = newValue.doubleValue() - oldValue.doubleValue();
        return new Precision<>(Math.abs(difference));
    }
}
