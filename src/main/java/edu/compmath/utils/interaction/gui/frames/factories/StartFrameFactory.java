package edu.compmath.utils.interaction.gui.frames.factories;

import edu.compmath.utils.interaction.gui.frames.AppFrame;
import edu.compmath.utils.interaction.gui.frames.StartFrame;

import java.util.Map;

public class StartFrameFactory extends AppFrameFactory {


    @Override
    public AppFrame create() {
        return new StartFrame();
    }
}
