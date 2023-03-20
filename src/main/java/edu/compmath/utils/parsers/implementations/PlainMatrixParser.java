package edu.compmath.utils.parsers.implementations;

import edu.compmath.math_section.linear_algebra.enitities.Matrix;
import edu.compmath.utils.exceptions.matrix.InvalidMatrixElementException;
import edu.compmath.utils.exceptions.matrix.InvalidMatrixSizeException;
import edu.compmath.utils.parsers.EntityParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class PlainMatrixParser implements EntityParser<Matrix, List<String[]>> {

    /**
     * @param stringMatrix String list, containing matrix rows, separated by newline symbol and elements, separated by spaces.
     * @return
     * @throws InvalidMatrixSizeException if matrix's rows or column's length is not equal among them.
     * @throws IllegalArgumentException   if any element is not a number.
     */
    public static Matrix parseMatrixByRows(List<String[]> stringMatrix) throws InvalidMatrixSizeException, IllegalArgumentException {
        int rowsAmount = stringMatrix.size();
        int columnsAmount = stringMatrix.get(0).length;
        int previousElemArrayLength = columnsAmount;

        Double[][] matrix = new Double[rowsAmount][columnsAmount];

        for (int i = 0; i < rowsAmount; i++) {
            String[] currentArray = stringMatrix.get(i);
            int currentArrayLength = currentArray.length;
            if (currentArrayLength == previousElemArrayLength) {
                Double[] currentLine = new Double[currentArrayLength];
                try {
                    for (int j = 0; j < currentArrayLength; j++) {
                        currentLine[j] = Double.parseDouble(currentArray[j]);
                    }
                    matrix[i] = currentLine;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Some elements are not valid for type Double.");
                }
            }
        }
        return new Matrix(matrix, rowsAmount, columnsAmount);
    }

    public static Matrix parseMatrixByArrays(List<String[]> stringMatrix) throws InvalidMatrixSizeException, IllegalArgumentException, InvalidMatrixElementException {
        int rowsAmount = 0;
        int columnsAmount = 0;

        List<String[]> parsedRowsList = new ArrayList<>();
        {
            Stack<String> bracketStack = new Stack<>();
            List<String> currentRow = new ArrayList<>();

            int previousAmount = 0;
            int currentAmount = 0;
            for (var array : stringMatrix) {
                for (var element : array) {
                    if ("[".equals(element) || "]".equals(element)) {
                        if (bracketStack.isEmpty()) {
                            if ("[".equals(element)) {
                                bracketStack.push(element);
                            } else {
                                throw new IllegalArgumentException("Brackets order is not valid.");
                            }
                        } else if (bracketStack.size() == 2) {
                            if ("]".equals(element)) {
                                if (currentAmount == 0) {
                                    throw new InvalidMatrixElementException("Some row is empty.");
                                } else if (previousAmount == 0) {
                                    previousAmount = currentAmount;
                                    columnsAmount = previousAmount;
                                    currentAmount = 0;
                                    parsedRowsList.add(currentRow.toArray(String[]::new));
                                    currentRow.clear();
                                    rowsAmount++;
                                    bracketStack.pop();
                                } else if (currentAmount != previousAmount) {
                                    throw new InvalidMatrixSizeException("Rows are not size equal.");
                                } else {
                                    currentAmount = 0;
                                    parsedRowsList.add(currentRow.toArray(String[]::new));
                                    currentRow.clear();
                                    rowsAmount++;
                                    bracketStack.pop();
                                }

                            } else {
                                throw new InvalidMatrixElementException("Brackets order is not valid.");
                            }
                        } else if (bracketStack.size() > 2) {
                            throw new InvalidMatrixElementException("Matrix embedded into matrix. Fix this.");
                        }
                        // if (bracketStack.size() == 1)
                        else if (currentAmount == 0) {
                            if ("]".equals(element) && rowsAmount == 0) {
                                throw new InvalidMatrixSizeException("Empty matrix or invalid brackets order.");
                            } else {
                                bracketStack.push(element);
                            }
                        } else {
                            throw new InvalidMatrixElementException("Row elements outside brackets.");
                        }
                    } else if (element.matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$")) {
                        currentAmount++;
                        currentRow.add(element);
                        continue;
                    } else {
                        throw new IllegalArgumentException("Some elements are not numbers.");
                    }
                }
            }
        }
        return parseMatrixByRows(parsedRowsList);
    }

    @Override
    public Matrix parseEntity(List<String[]> strings) throws InvalidMatrixSizeException, IllegalArgumentException {
        try {
            return parseMatrixByRows(strings);
        } catch (IllegalArgumentException e) {
            return parseMatrixByArrays(strings);
        }
    }
}
