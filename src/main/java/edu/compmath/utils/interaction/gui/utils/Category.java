package edu.compmath.utils.interaction.gui.utils;

import java.util.Map;

/**
 *
 * @param <T> type of elements, stored by given name.
 */
public class Category<T> {
    protected Map<String, T> category;

    public Category(Map<String, T> elementsMap) {
        this.category = elementsMap;
    }

    public Map<String, T> getCategory() {
        return this.category;
    }
}
