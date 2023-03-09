package edu.compmath.utils.managing.commands.implementations.linear_algebra;

import edu.compmath.math_section.linear_algebra.enitities.Matrix;
import edu.compmath.utils.io.readers.ConsoleReader;
import edu.compmath.utils.managing.commands.Command;

import java.util.HashMap;
import java.util.Map;

public class InsertMatrixCommand extends Command {
    private final static String name = "insert matrix";
    private final static String description = "command initializes matrix." +
            " User has to choose whether to insert matrix by manual import or" +
            " by passing the path to file with the matrix.";
    private final static Map<String, String> acceptableArgs = new HashMap<>();
    static {
        acceptableArgs.put("f", "insert matrix from existing file on the computer.");
        acceptableArgs.put("m", "manual row by row matrix insertion.");
    }
    private Matrix matrix;

    public InsertMatrixCommand(Matrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public void execute(String[] args) {
        // todo вставка матриц, выбор из файла или вручную
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
