package edu.compmath.utils.interaction.gui;

import edu.compmath.Main;
import edu.compmath.utils.interaction.CommandScanner;
import edu.compmath.utils.interaction.gui.frames.AppFrame;
import edu.compmath.utils.interaction.gui.utils.Category;
import edu.compmath.utils.interaction.gui.utils.InteractionElementsCategory;
import edu.compmath.utils.io.Reader;
import edu.compmath.utils.io.readers.GUIReader;

import java.io.IOException;
import java.util.Map;

public class GUIScanner implements CommandScanner {
//    private final Map<String, Category<InteractionElementsCategory>> mapOfCategoriesOf;
    public GUIScanner(AppFrame currentFrame) {
//        this.mapOfCategoriesOf = currentFrame.
    }

    @Override
    public String scan() throws IOException {
        return Main.getReader().read();
    }
}
