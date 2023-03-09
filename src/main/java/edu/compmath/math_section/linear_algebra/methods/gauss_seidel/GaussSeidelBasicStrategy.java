package edu.compmath.math_section.linear_algebra.methods.gauss_seidel;

import edu.compmath.math_section.linear_algebra.MatrixSolvingStrategy;
import edu.compmath.math_section.linear_algebra.enitities.Matrix;

import java.util.List;

public class GaussSeidelBasicStrategy extends MatrixSolvingStrategy<Matrix, Double> {

    public GaussSeidelBasicStrategy(Matrix matrix, Double precision) {
        super(new GaussSeidel<>(matrix, precision), matrix);
    }

    @Override
    public void execute() {

    }
}
