package edu.compmath.math_section.linear_algebra.enitities.matrix.utils;

import edu.compmath.math_section.utils.Element;

import java.util.List;

public class Row<T extends Number> extends Column<T> {

    public Row(List<Element<T>> content) {
        super(content);
    }

    public Row(int capacity) {
        super(capacity);
    }
}
