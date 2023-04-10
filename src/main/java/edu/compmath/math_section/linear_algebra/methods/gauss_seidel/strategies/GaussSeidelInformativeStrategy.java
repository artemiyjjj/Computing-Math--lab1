package edu.compmath.math_section.linear_algebra.methods.gauss_seidel.strategies;

import edu.compmath.math_section.linear_algebra.MatrixSolvingStrategy;
import edu.compmath.math_section.linear_algebra.enitities.matrix.Matrix;
import edu.compmath.math_section.linear_algebra.methods.gauss_seidel.GaussSeidelInformative;
import edu.compmath.math_section.utils.Precision;

public class GaussSeidelInformativeStrategy extends MatrixSolvingStrategy<Double> {

    public GaussSeidelInformativeStrategy(Matrix matrix, Precision<Double> precision) {
        super(new GaussSeidelInformative(matrix, precision));
    }
}
