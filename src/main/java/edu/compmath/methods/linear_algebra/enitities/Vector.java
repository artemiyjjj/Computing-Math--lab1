package edu.compmath.methods.linear_algebra.enitities;

import edu.compmath.methods.MathEntities;

public class Vector<T extends Number> extends MathEntities<T> {
    protected final T[][] content;

    public Vector(T[][] content) {
        this.content = content;
    }

    public T at(int rowOrColumn) {
        return content[][];
    }
}
