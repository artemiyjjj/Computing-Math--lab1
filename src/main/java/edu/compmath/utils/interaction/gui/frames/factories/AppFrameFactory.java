package edu.compmath.utils.interaction.gui.frames.factories;

import edu.compmath.utils.Factory;
import edu.compmath.utils.interaction.gui.frames.AppFrame;

import java.util.Map;

public abstract class AppFrameFactory implements Factory<AppFrame> {
    protected static Map<Class<?>, AppFrameFactory> acceptableFrames;

    public static void setAcceptableFrames(Map<Class<?>, AppFrameFactory> framesFactories) {
        acceptableFrames = framesFactories;
    }

    public abstract AppFrame create();
}
