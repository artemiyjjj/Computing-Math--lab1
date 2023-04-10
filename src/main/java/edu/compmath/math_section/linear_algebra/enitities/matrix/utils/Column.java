package edu.compmath.math_section.linear_algebra.enitities.matrix.utils;

import edu.compmath.math_section.utils.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <T> Value of element type.
 */
public class Column<T extends Number> {
    protected final List<Element<T>> content;

    public Column(List<Element<T>> content) {
        this.content = content;
    }

    public Column(int capacity) {
        this.content = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            content.add(new Element<>());
        }
    }

    public List<Element<T>> getContent() {
        return content;
    }

    public Element<T> getElementAt(int position) {
        return content.get(position);
    }

    public int getSize() {
        return this.content.size();
    }

    public void setContent(List<Element<T>> content) {
        this.content.clear();
        this.content.addAll(content);
    }

    public void setSpecificElement(int elementPosition, Element<T> newElementValue) {
        this.content.set(elementPosition, newElementValue);
    }


}
