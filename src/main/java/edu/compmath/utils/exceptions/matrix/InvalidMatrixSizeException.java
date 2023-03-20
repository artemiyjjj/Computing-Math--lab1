package edu.compmath.utils.exceptions.matrix;

import edu.compmath.utils.exceptions.MatrixException;

public class InvalidMatrixSizeException extends MatrixException {
    public InvalidMatrixSizeException(String message) {
        super(message);
    }
}
