package edu.compmath.math_section.linear_algebra.methods.gauss_seidel;

import edu.compmath.Main;
import edu.compmath.math_section.Calculator;
import edu.compmath.math_section.linear_algebra.enitities.matrix.Matrix;
import edu.compmath.math_section.linear_algebra.enitities.matrix.utils.MatrixActions;
import edu.compmath.math_section.utils.Precision;

import java.util.List;

public class GaussSeidelInformative implements Calculator<List<Double>> {
    protected final GaussSeidel calcMethod;

    public GaussSeidelInformative(Matrix matrix, Precision<Double> precision) {
        this.calcMethod = new GaussSeidel(matrix, precision);
    }

    @Override
    public List<Double> calc() {
        if (!calcMethod.checkConvergenceCondition()) {
            MatrixActions.optimizeToDiagonalDomination(this.calcMethod.matrix);
            if (!calcMethod.checkConvergenceCondition()) {
                return null;
            }
        }
        do {
            calcMethod.getOldIteration().clear();
            calcMethod.getOldIteration().addAll(calcMethod.getNewIteration());
            calcMethod.getNewIteration().clear();
            this.doIteration();
            Main.getWriter().write(buildStatus(calcMethod.getIterationCounter(), calcMethod.getOldIteration(),
                    calcMethod.getNewIteration(), calcMethod.lastIterationPrecision));
        }
        while (calcMethod.getIterationCounter() < calcMethod.MAX_ITERATION_COUNTER && !calcMethod.getIsPrecisionSatisfied());
        Main.getWriter().write(calcMethod.getIterationCounter() > calcMethod.MAX_ITERATION_COUNTER ? "Possibly endless cycle." : "Calculations completed");
        return calcMethod.getNewIteration();
    }

    @Override
    public List<Double> doIteration() {
        return calcMethod.doIteration();
    }

    @Override
    public int getIterationCounter() {
        return calcMethod.getIterationCounter();
    }

    protected String buildStatus(int iterationIndex, List<Double> oldIteration, List<Double> newIteration, List<Precision<Double>> precisions) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Iteration: ").append(iterationIndex)
                .append("\n").append("\t").append("X values and precisions:").append("\n");
        for (int i = 0; i < newIteration.size(); i++) {
            stringBuilder.append("\t").append("i=").append(i + 1).append(" x[k]: ")
                    .append(oldIteration.get(i).toString()).append("\t")
                    .append("x[k+1]: ").append(newIteration.get(i).toString()).append("\t")
                    .append("precision: ").append(precisions.get(i).toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
