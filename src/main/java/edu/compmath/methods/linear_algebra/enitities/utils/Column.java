package edu.compmath.methods.linear_algebra.enitities.utils;

import java.util.ArrayList;
import java.util.List;

public class Column<S extends Element<T>, T extends Number> {
    protected Element<T>[] content;

    public Column(Element<T>[] content) {
        this.content = content;
    }

    public Column() {

    }

    public Element<T>[] getContent() {
        return content;
    }

    public void setContent(Element<T>[] content) {
        this.content = content;
    }

    public void setSpecificElement(int elementPosition, Element<T> newElementValue) {
        if (content != null && elementPosition < content.length) {
            this.content[elementPosition] = newElementValue;
        }
    }


}
