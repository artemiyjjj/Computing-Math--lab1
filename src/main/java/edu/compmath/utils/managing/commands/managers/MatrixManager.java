package edu.compmath.utils.managing.commands.managers;

import edu.compmath.math_section.linear_algebra.enitities.matrix.Matrix;

public class MatrixManager extends MathEntityManager<Matrix>{

    public MatrixManager() {}

    public Matrix getEntity() {
        return this.entity;
    }

    public void setEntity(Matrix matrix) {
        this.entity = matrix;
    }
}
