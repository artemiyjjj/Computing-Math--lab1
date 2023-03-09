package edu.compmath.math_section.linear_algebra.methods.gauss_seidel;

import edu.compmath.math_section.Calculator;
import edu.compmath.math_section.linear_algebra.MatrixSolvingStrategy;
import edu.compmath.math_section.linear_algebra.enitities.Matrix;
import edu.compmath.utils.io.Writer;

import java.util.List;

public class GaussSeidelInformativeStrategy extends MatrixSolvingStrategy<Matrix, Double> {

    public GaussSeidelInformativeStrategy(Matrix matrix, Double precision) {
        super(new GaussSeidelInformative<>(matrix, precision), matrix);
    }
}
