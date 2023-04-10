package edu.compmath.utils.managing.commands.implementations.linear_algebra;

import edu.compmath.Main;
import edu.compmath.math_section.linear_algebra.enitities.matrix.Matrix;
import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.managers.MathEntityManager;

import java.util.HashMap;
import java.util.Map;

public class DisplayMatrixCommand extends Command {
    private final static String name = "display_matrix";
    private final static String description = "command displays matrix.";
    private final static Map<String, String> acceptableArgs = new HashMap<>();

    private final MathEntityManager<Matrix> matrixManager;

    public DisplayMatrixCommand(MathEntityManager<Matrix> matrixManager) {
        this.matrixManager = matrixManager;
    }

    @Override
    public void execute(String[] args) {
        if (matrixManager.getEntity() != null) {
            Main.getWriter().write("Matrix representation:\n");
            Main.getWriter().write(matrixManager.getEntity().display());
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
