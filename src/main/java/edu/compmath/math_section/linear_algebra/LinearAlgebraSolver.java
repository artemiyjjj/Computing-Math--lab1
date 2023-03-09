package edu.compmath.math_section.linear_algebra;

import edu.compmath.math_section.CalculactionContext;
import edu.compmath.math_section.CalculationStrategy;
import edu.compmath.math_section.linear_algebra.enitities.Matrix;

public class LinearAlgebraSolver<S extends Matrix, T extends Number> extends CalculactionContext {

    public LinearAlgebraSolver(MatrixSolvingStrategy<S, T> strategy) {
        super(strategy);
    }

    public LinearAlgebraSolver() {}




}
