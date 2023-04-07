package edu.compmath.utils.managing.commands.managers;

import edu.compmath.math_section.linear_algebra.enitities.matrix.Matrix;

public class MatrixManager {
    private Matrix matrix;

    public MatrixManager() {}

    public Matrix getMatrix() {
        return this.matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }
}
