package edu.compmath.utils.managing.commands.implementations.linear_algebra;

import edu.compmath.Main;
import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.managers.MatrixManager;

import java.util.HashMap;
import java.util.Map;

public class DisplayMatrixCommand extends Command {
    private final static String name = "display_matrix";
    private final static String description = "command displays matrix.";
    private final static Map<String, String> acceptableArgs = new HashMap<>();

    private final MatrixManager matrixManager;

    public DisplayMatrixCommand(MatrixManager matrixManager) {
        this.matrixManager = matrixManager;
    }

    @Override
    public void execute(String[] args) {
        if (matrixManager.getMatrix() != null) {
            Main.getWriter().write("Matrix representation:\n");
            Main.getWriter().write(matrixManager.getMatrix().display());
        }
        else {
            Main.getWriter().write("Matrix is not initialized.");
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Map<String, String> getAcceptableArgs() {
        return acceptableArgs;
    }
}
