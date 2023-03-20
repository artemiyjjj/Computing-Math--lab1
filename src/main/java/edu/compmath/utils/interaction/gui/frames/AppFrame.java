package edu.compmath.utils.interaction.gui.frames;

import edu.compmath.utils.interaction.gui.utils.Category;
import edu.compmath.utils.interaction.gui.utils.InteractionElementsCategory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AppFrame extends JFrame {
    protected final Map<String, List<Category<InteractionElementsCategory>>> categoryMap = new HashMap<>();
    protected final List<String> categoriesNames = new ArrayList<>();

    public AppFrame() {}

    public List<String> getCategoriesNames() {
        return this.categoriesNames;
    }

    public List<Category<InteractionElementsCategory>> getCategoryByName(String categoryName) {
        return this.categoryMap.get(categoryName);
    }
}
