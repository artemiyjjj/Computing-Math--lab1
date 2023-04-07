package edu.compmath.math_section.linear_algebra.methods.gauss_seidel;

import edu.compmath.math_section.Calculator;
import edu.compmath.math_section.linear_algebra.enitities.matrix.Matrix;
import edu.compmath.math_section.linear_algebra.enitities.matrix.utils.Element;
import edu.compmath.math_section.linear_algebra.enitities.matrix.utils.MatrixActions;
import edu.compmath.math_section.linear_algebra.enitities.matrix.utils.Row;
import edu.compmath.math_section.linear_algebra.methods.gauss_seidel.utils.Precision;
import edu.compmath.math_section.linear_algebra.methods.gauss_seidel.utils.PrecisionCalculator;

import java.util.ArrayList;
import java.util.List;

public class GaussSeidel implements Calculator<List<Double>> {
    public final int MAX_ITERATION_COUNTER = 100;
    protected int iterationCounter = 0; // k
    protected final List<Double> oldIteration; // x_{k}
    protected final List<Double> newIteration; // x_{k+1}
    protected volatile boolean isIterationComplete = false;
    protected final Precision<Double> precision;
    protected volatile boolean isPrecisionSatisfied = false;
    protected List<Precision<Double>> lastIterationPrecision;
    protected final Matrix matrix;
    protected final int amountOfRoots;
    protected final PrecisionCalculator<Double> precisionCalculator = new PrecisionCalculator<>();


    public GaussSeidel(Matrix matrix, double precision) {
        this.matrix = matrix;
        this.precision = new Precision<>(precision);
        this.amountOfRoots = matrix.getColumnsAmount() - 1;
        this.oldIteration = new ArrayList<>(amountOfRoots);
        this.newIteration = new ArrayList<>(amountOfRoots);
    }

    /**
     *
     * @return returns list of results in straight order of roots. null - if system cannot be solved.
     */
    @Override
    public List<Double> calc() {
        if (!checkConvergenceCondition()) {
            MatrixActions.optimizeToDiagonalDomination(this.matrix);
            if (!checkConvergenceCondition()) {
                return null;
            }
        }
        do {
            oldIteration.clear();
            oldIteration.addAll(newIteration);
            newIteration.clear();
            doIteration();
        }
        while (iterationCounter < MAX_ITERATION_COUNTER && !isPrecisionSatisfied);
        return newIteration;
    }

    @Override
    public List<Double> doIteration() {
        this.isIterationComplete = false;
        List<Element<Double>> bColumn = matrix.getColumnAsList(matrix.getColumnsAmount() - 1);
        if (oldIteration.size() == 0) {
            initializeMethod();
        }
        for (int i = 0; i < amountOfRoots; i++) {
            double sumOfRow = 0;
            for (int j = 0; j < amountOfRoots - 1; j++) {
                double curElement = matrix.at(i, j).getValue();
//                if (curElement != 0) {
                    if (i < j) {
                        sumOfRow += curElement * oldIteration.get(j);
                    } else if (i > j) {
                        sumOfRow += curElement * newIteration.get(j);
                    }
//                }
            }
            sumOfRow -= bColumn.get(i).getValue();
            sumOfRow /= -matrix.at(i,i).getValue();
            newIteration.add(sumOfRow); // oldIteration.get(i) - sumOfRow
        }
        iterationCounter++;
        lastIterationPrecision = calcPrecision(oldIteration, newIteration);
        if (checkPrecision(lastIterationPrecision)) {
            completeCalculations();
        }
        this.isIterationComplete = true;
        return newIteration;
    }

    private Double countSumOfRowByAbs(Row<Double> row) {
        double sumOfRow = 0;
        for (int i = 0; i < row.getSize() - 1; i++) {
            sumOfRow += Math.abs(row.getContent().get(i).getValue());
        }
        return sumOfRow;
    }

    public boolean checkConvergenceCondition() {
        boolean isAnyBiggerThanCondition = false;

        for (int i = 0; i < matrix.getRowsAmount(); i++) {
            Double curElement = Math.abs(matrix.at(i, i).getValue());
            double rowSum = countSumOfRowByAbs(matrix.getRow(i)) - curElement;
            if (rowSum > curElement) {
                return false;
            } else if (rowSum <= curElement) {
                if (!isAnyBiggerThanCondition && rowSum < curElement) {
                    isAnyBiggerThanCondition = true;
                }
                continue;
            }
        }
        return isAnyBiggerThanCondition;
    }


    private void initializeMethod() {
//        List<Element<Double>> bColumn = matrix.getColumnAsList(matrix.getColumnsAmount() - 1);
        for (int i = 0; i < amountOfRoots; i++) {
            Double xK0 = 0d;//matrix.at(i, i).getValue() - bColumn.get(i).getValue();
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
