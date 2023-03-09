package edu.compmath.math_section.linear_algebra.methods.gauss_seidel.utils;

import java.util.Objects;

public class Precision<T>{
    protected final T value;
    public Precision(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Precision)) return false;
        Precision<?> precision = (Precision<?>) o;
        return value.equals(precision.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
