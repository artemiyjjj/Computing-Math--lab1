package edu.compmath.math_section.linear_algebra;

import edu.compmath.Main;
import edu.compmath.math_section.CalculationStrategy;
import edu.compmath.math_section.Calculator;
import edu.compmath.math_section.linear_algebra.enitities.matrix.Matrix;

import java.util.List;

public abstract class MatrixSolvingStrategy<T extends Number> implements CalculationStrategy {
    private final Calculator<List<T>> matrixCalculator;

    public MatrixSolvingStrategy(Calculator<List<T>> matrixCalculator) {
        this.matrixCalculator = matrixCalculator;
    }
    @Override
    public void execute() {
        List<T> result = matrixCalculator.calc();
        Main.getWriter().write( result != null ? formatResult(result) : "This system can not be solved.");
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
