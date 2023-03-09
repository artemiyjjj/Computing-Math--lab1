package edu.compmath.math_section;

/**
 *
 * @param <T> returning type
 * @param <S> consuming type
 */
public interface Calculator<T, S> {
    T calc(S s);
    T doIteration();
}
