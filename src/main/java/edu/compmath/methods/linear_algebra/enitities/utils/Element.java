package edu.compmath.methods.linear_algebra.enitities.utils;

public class Element<T> {
    private T value;

    public Element(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
