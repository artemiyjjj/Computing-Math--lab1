package edu.compmath.utils;

public interface Observable<T, S> {
    void notifyObserversOfUpdate(S[] s);
    void notifyObserversOfExecution(T[] t);
    void removeObserver(Observer<T, S> observer);
    void addObserver(Observer<T, S> observer);
}
