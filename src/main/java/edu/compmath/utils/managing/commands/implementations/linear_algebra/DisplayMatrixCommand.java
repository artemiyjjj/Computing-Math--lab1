package edu.compmath.utils.managing.commands.implementations.linear_algebra;

import edu.compmath.Main;
import edu.compmath.math_section.linear_algebra.enitities.Matrix;
import edu.compmath.utils.managing.commands.Command;

import java.util.HashMap;
import java.util.Map;

public class DisplayMatrixCommand extends Command {
    private final static String name = "display_matrix";
    private final static String description = "command displays matrix.";
    private final static Map<String, String> acceptableArgs = new HashMap<>();

    private Matrix matrix;

    public DisplayMatrixCommand(Matrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public void execute(String[] args) {
        if (matrix != null) {
            Main.getWriter().write("Matrix representation:\n");
            Main.getWriter().write(matrix.display());
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
