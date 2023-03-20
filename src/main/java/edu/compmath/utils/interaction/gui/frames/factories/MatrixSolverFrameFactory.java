package edu.compmath.utils.interaction.gui.frames.factories;

import edu.compmath.utils.interaction.gui.frames.AppFrame;
import edu.compmath.utils.interaction.gui.frames.MatrixSolverFrame;

public class MatrixSolverFrameFactory extends AppFrameFactory {

    @Override
    public AppFrame create() {
        return new MatrixSolverFrame();
    }
}
