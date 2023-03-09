package edu.compmath.utils.parsers;

/**
 *
 * @param <T> returning type
 * @param <S> consuming type
 */
public interface EntityParser<T, S> {
    T parseEntity(S s);
}
