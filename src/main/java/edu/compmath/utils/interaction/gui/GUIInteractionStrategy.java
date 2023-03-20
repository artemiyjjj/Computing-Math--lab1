package edu.compmath.utils.interaction.gui;

import edu.compmath.utils.interaction.InteractionStrategy;
import edu.compmath.utils.interaction.gui.frames.AppFrame;
import edu.compmath.utils.interaction.gui.frames.MatrixSolverFrame;
import edu.compmath.utils.interaction.gui.frames.StartFrame;
import edu.compmath.utils.interaction.gui.frames.factories.AppFrameFactory;
import edu.compmath.utils.interaction.gui.frames.factories.MatrixSolverFrameFactory;
import edu.compmath.utils.interaction.gui.frames.factories.StartFrameFactory;

import java.util.HashMap;
import java.util.Map;

public class GUIInteractionStrategy extends InteractionStrategy {
    // all frames from "src/main/java/edu/compmath/utils/interaction/gui/frames"
    private AppFrame currentFrame;
    private final Map<Class<?>, AppFrameFactory> appFrameMap;


    /**
     * have to add new frames to be shown to this constructor and don't forget to call set.
     */
    public GUIInteractionStrategy() {
        appFrameMap = new HashMap<>();
        {
            appFrameMap.put(StartFrame.class, new StartFrameFactory());
            appFrameMap.put(MatrixSolverFrame.class, new MatrixSolverFrameFactory());
        }
        AppFrameFactory.setAcceptableFrames(appFrameMap);
    }

//    @Override
//    public String[] startScanning() throws IOException {
//        return stringPrettifyParser.handleLine(this.commandScanner.scan());
//    }

    @Override
    public void execute() {
        //todo render frames
    }

}
