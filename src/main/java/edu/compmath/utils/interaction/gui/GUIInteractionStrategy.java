package edu.compmath.utils.interaction.gui;

import edu.compmath.utils.interaction.CommandScanner;
import edu.compmath.utils.interaction.InteractionStrategy;
import edu.compmath.utils.interaction.gui.frames.MatrixSolverFrame;
import edu.compmath.utils.io.Reader;
import edu.compmath.utils.io.Writer;
import edu.compmath.utils.io.readers.GUIReader;
import edu.compmath.utils.io.writers.GUIWriter;

import java.io.IOException;

public class GUIInteractionStrategy extends InteractionStrategy {
    // all frames from "src/main/java/edu/compmath/utils/interaction/gui/frames"
    private MatrixSolverFrame matrixSolverFrame;


    public GUIInteractionStrategy() {
        super(new GUIScanner(new GUIReader(null))); //todo fix gui reader
//        this.scanner = new GUIScanner();
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
