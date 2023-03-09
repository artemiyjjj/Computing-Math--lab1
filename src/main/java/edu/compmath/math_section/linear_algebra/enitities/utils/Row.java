package edu.compmath.section.linear_algebra.enitities.utils;

import java.util.List;

public class Row<S extends Element<T>, T extends Number> extends Column<S, T> {

    public Row(List<Element<T>> content) {
        super(content);
    }

    public Row(int capacity) {
        super(capacity);
    }
}
