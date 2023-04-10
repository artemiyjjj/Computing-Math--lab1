package edu.compmath.math_section;

/**
 *
 * @param <T> returning type
 */
public interface Calculator<T> {
    T calc();
    T doIteration();
    int getIterationCounter();
}
