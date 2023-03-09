package edu.compmath.math_section.linear_algebra;

import edu.compmath.Main;
import edu.compmath.math_section.CalculationStrategy;
import edu.compmath.math_section.Calculator;
import edu.compmath.math_section.linear_algebra.enitities.Matrix;

import java.util.List;

public abstract class MatrixSolvingStrategy<S extends Matrix, T extends Number> implements CalculationStrategy {
    private final Calculator<List<T>, S> matrixCalculator;
    private final S matrix;

    public MatrixSolvingStrategy(Calculator<List<T>, S> matrixCalculator, S matrix) {
        this.matrixCalculator = matrixCalculator;
        this.matrix = matrix;
    }
    @Override
    public void execute() {
        List<T> result = matrixCalculator.calc(matrix);
        Main.getWriter().write(formatResult(result));
    }

    protected String formatResult(List<T> result) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Calculated values: ").append("\n");
        for (int i = 0; i < result.size(); i++) {
            stringBuilder.append("\t").append("x[").append(i+1).append("]: ")
                    .append(result.get(i).toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
