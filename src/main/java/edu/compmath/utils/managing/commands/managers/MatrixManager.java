package edu.compmath.utils.managing.commands.managers;

import edu.compmath.math_section.linear_algebra.enitities.Matrix;

public class MatrixManager {
    private Matrix matrix = new Matrix(new Double[][]{{1d}, {1d}}, 1, 1);

    public MatrixManager() {}

    public Matrix getMatrix() {
        return this.matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }
}
