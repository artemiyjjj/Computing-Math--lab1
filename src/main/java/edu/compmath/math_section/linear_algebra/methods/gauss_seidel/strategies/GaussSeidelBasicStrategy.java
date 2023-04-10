package edu.compmath.math_section.linear_algebra.methods.gauss_seidel.strategies;

import edu.compmath.math_section.linear_algebra.MatrixSolvingStrategy;
import edu.compmath.math_section.linear_algebra.enitities.matrix.Matrix;
import edu.compmath.math_section.linear_algebra.methods.gauss_seidel.GaussSeidel;
import edu.compmath.math_section.utils.Precision;

public class GaussSeidelBasicStrategy extends MatrixSolvingStrategy<Double> {

    public GaussSeidelBasicStrategy(Matrix matrix, Precision<Double> precision) {
        super(new GaussSeidel(matrix, precision));
    }

}
