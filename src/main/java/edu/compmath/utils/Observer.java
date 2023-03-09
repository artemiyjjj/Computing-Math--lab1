package edu.compmath.utils;

public interface Observer<T, S> {
    void notifyOfUpdate(S[] s);
    void notifyOfExecution(T[] t);
}
