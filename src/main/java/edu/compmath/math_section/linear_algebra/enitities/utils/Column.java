package edu.compmath.section.linear_algebra.enitities.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <S> Element type.
 * @param <T> Value of element type.
 */
public class Column<S extends Element<T>, T extends Number> {
    protected List<Element<T>> content;

    public Column(List<Element<T>> content) {
        this.content = content;
    }

    public Column(int capacity) {
        this.content = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {content.add(new Element<>());}
    }

    public List<Element<T>> getContent() {
        return content;
    }

    public Element<T> getElementAt(int position) {
        return content.get(position);
    }

    public void setContent(List<Element<T>> content) {
        this.content = content;
    }

    public void setSpecificElement(int elementPosition, Element<T> newElementValue) {
        if (content != null) {
            this.content.set(elementPosition, newElementValue);
        }
    }


}
