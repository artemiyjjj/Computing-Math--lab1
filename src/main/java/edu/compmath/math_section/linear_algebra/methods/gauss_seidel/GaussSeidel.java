package edu.compmath.math_section.linear_algebra.methods.gauss_seidel;

import edu.compmath.math_section.Calculator;
import edu.compmath.math_section.linear_algebra.enitities.Matrix;
import edu.compmath.math_section.linear_algebra.enitities.utils.Element;
import edu.compmath.math_section.linear_algebra.methods.gauss_seidel.utils.Precision;
import edu.compmath.math_section.linear_algebra.methods.gauss_seidel.utils.PrecisionCalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <S> matrix or extended type containing elememts of T type.
 */
public class GaussSeidel<S extends Matrix> implements Calculator<List<Double>, S> {
    protected int iterationCounter = 0; // k
    protected final List<Double> oldIteration; // x_{k}
    protected final List<Double> newIteration; // x_{k+1}
    protected volatile boolean isIterationComplete = false;
    protected final Precision<Double> precision;
    protected volatile boolean isPrecisionSatisfied = false;
    protected List<Precision<Double>> lastIterationPrecision;
    protected final S matrix;
    protected final int amountOfRoots;
    protected final PrecisionCalculator<Double> precisionCalculator = new PrecisionCalculator<>();


    public GaussSeidel(S matrix, double precision) {
        this.matrix = matrix;
        this.precision = new Precision<>(precision);
        this.amountOfRoots = matrix.getColumnsAmount();
        this.oldIteration = new ArrayList<>(amountOfRoots);
        this.newIteration = new ArrayList<>(amountOfRoots);
    }

    @Override
    public List<Double> calc(S matrix) {
        List<Double> result;
        do {
            oldIteration.clear();
            oldIteration.addAll(newIteration);
            result = doIteration();
        }
        while (isPrecisionSatisfied);
        return result;
    }

    @Override
    public List<Double> doIteration() {
        if (isPrecisionSatisfied) {
            return null;
        }
        if (oldIteration.size() == 0) {
            initializeMethod();
        }
        for (int i = 0; i < amountOfRoots; i++) {
            double sumOfRow = 0;
            for (int j = 0; j < amountOfRoots; j++) {
                if (i < j) {
                    sumOfRow += matrix.at(i, j).getValue() * oldIteration.get(j);
                } else if (i > j) {
                    sumOfRow += matrix.at(i, j).getValue() * newIteration.get(j);
                }
            }
            newIteration.add(sumOfRow);
        }
        iterationCounter++;
        lastIterationPrecision = calcPrecision(oldIteration, newIteration);
        if (checkPrecision(lastIterationPrecision)) {
            completeCalculations();
        }
        return newIteration;
    }


    private void initializeMethod() {
        List<Element<Double>> bColumn = matrix.getColumnAsList(matrix.getColumnsAmount() - 1);
        for (int i = 0; i < amountOfRoots; i++) {
            Double xK0 = matrix.at(i, i).getValue() - bColumn.get(i).getValue();
            oldIteration.add(xK0);
        }

    }

    private List<Precision<Double>> calcPrecision(List<Double> oldValues, List<Double> newValues) {
        List<Precision<Double>> precisionList = new ArrayList<>(oldValues.size());
        for (int i = 0; i < oldValues.size(); i++) {
            Precision<Double> precision = precisionCalculator.calc(newValues.get(i), oldValues.get(i));
            precisionList.add(precision);
        }
        return precisionList;
    }

    private boolean checkPrecision(List<Precision<Double>> precisions) {
        int satisfyingConditionsCounter = 0;
        for (var concretePrecision : precisions) {
            if (concretePrecision.getValue() <= precision.getValue()) {
                satisfyingConditionsCounter++;
            }
        }
        return satisfyingConditionsCounter == amountOfRoots;
    }

    private void completeCalculations() {
        isPrecisionSatisfied = true;
    }

    public int getIterationCounter() {
        return this.iterationCounter;
    }

    public List<Double> getOldIteration() {
        return this.oldIteration;
    }

    public List<Double> getNewIteration() {
        return this.newIteration;
    }

    public List<Precision<Double>> getLastIterationPrecision() {
        return this.lastIterationPrecision;
    }

    public boolean getIsPrecisionSatisfied() {
        return this.isPrecisionSatisfied;
    }
}
