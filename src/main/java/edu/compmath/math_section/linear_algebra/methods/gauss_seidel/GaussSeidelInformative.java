package edu.compmath.math_section.linear_algebra.methods.gauss_seidel;

import edu.compmath.Main;
import edu.compmath.math_section.Calculator;
import edu.compmath.math_section.linear_algebra.enitities.Matrix;
import edu.compmath.math_section.linear_algebra.methods.gauss_seidel.utils.Precision;
import edu.compmath.utils.io.Writer;

import java.util.List;

public class GaussSeidelInformative<S extends Matrix> implements Calculator<List<Double>, S> {
    protected final GaussSeidel<S> matrixSolver;

    public GaussSeidelInformative(S matrix, double precision) {
        this.matrixSolver = new GaussSeidel<>(matrix, precision);
    }

    @Override
    public List<Double> calc(S s) {
        List<Double> oldIteration = matrixSolver.getOldIteration();
        List<Double> newIteration = matrixSolver.getNewIteration();
        List<Precision<Double>> precisions = matrixSolver.getLastIterationPrecision();
        int iterationCounter = matrixSolver.getIterationCounter();
        List<Double> result;
        do {
            oldIteration.clear();
            oldIteration.addAll(newIteration);
            result = this.doIteration();
            Main.getWriter().write(buildStatus(iterationCounter, oldIteration, newIteration, precisions));
        }
        while (matrixSolver.getIsPrecisionSatisfied());
        Main.getWriter().write("Calculations completed");
        return result;
    }

    @Override
    public List<Double> doIteration() {
        return matrixSolver.doIteration();
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
