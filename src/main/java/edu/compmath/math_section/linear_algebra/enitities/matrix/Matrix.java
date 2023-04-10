package edu.compmath.math_section.linear_algebra.enitities.matrix;

import edu.compmath.math_section.utils.MathEntities;
import edu.compmath.math_section.linear_algebra.enitities.matrix.utils.Column;
import edu.compmath.math_section.utils.Element;
import edu.compmath.math_section.linear_algebra.enitities.matrix.utils.Row;
import edu.compmath.utils.exceptions.matrix.InvalidMatrixSizeException;

import java.util.ArrayList;
import java.util.List;

public class Matrix extends MathEntities<Double> {

    protected final int rowsAmount;
    protected final int columnsAmount;
    protected final List<Row<Double>> rowList;
    protected final List<Column<Double>> columnList;


    public Matrix(Double[][] content, int rowsAmount, int columnsAmount) throws InvalidMatrixSizeException {
        if (rowsAmount <= 0 || columnsAmount <= 0) { throw new InvalidMatrixSizeException("One of the matrix's size parameters is less or equal zero."); }

        this.rowsAmount = rowsAmount;
        this.columnsAmount = columnsAmount;
        this.rowList = new ArrayList<>(rowsAmount);
        this.columnList = new ArrayList<>(columnsAmount);

        for (int i = 0; i < columnsAmount; i++) {
            columnList.add(new Column<>(rowsAmount));
        }

        List<Element<Double>> tempRow = new ArrayList<>(columnsAmount);
        for (int i = 0; i < rowsAmount; i++) {
            rowList.add(new Row<>(columnsAmount));
            for (int j = 0; j < columnsAmount; j++) {
                Element<Double> currentElement = new Element<>(content[i][j]);
                tempRow.add(currentElement);
                Column<Double> c =  columnList.get(j);
                c.setSpecificElement(i, currentElement);
            }
            rowList.set(i, new Row<>(List.copyOf(tempRow)));
            tempRow.clear();
        }
    }

    public Element<Double> at(int rowIndex, int columnIndex) {
        return rowList.get(rowIndex).getElementAt(columnIndex);
    }

    public Row<Double> getRow(int index) {
        return rowList.get(index);
    }

    public List<Element<Double>> getRowAsList(int index) {
        return getRow(index).getContent();
    }

    public Column<Double> getColumn(int index) {
        return columnList.get(index);
    }

    public List<Element<Double>> getColumnAsList(int index) {
        return getColumn(index).getContent();
    }

    public void setRow(int index, Row<Double> newRow) throws IndexOutOfBoundsException {
        if (index >= rowsAmount) {
            throw new IndexOutOfBoundsException("Row index is out of bounds.");
        }
        this.rowList.set(index, newRow);
        // every column index
        for (int i = 0; i < columnsAmount - 1; i++) {
            var curColumn = this.columnList.get(i);
            curColumn.setSpecificElement(index, newRow.getElementAt(i));
            this.columnList.set(i, curColumn);
        }
    }

    public void setColumn(int index, Column<Double> newColumn) throws IndexOutOfBoundsException {
        if (index >= columnsAmount) {
            throw new IndexOutOfBoundsException("Column index is out of bounds.");
        }
        this.columnList.set(index, newColumn);
        for (int i =0; i < rowsAmount; i++) {
            var curRow = this.rowList.get(i);
            curRow.setSpecificElement(index, newColumn.getElementAt(i));
            this.rowList.set(i, curRow);
        }
    }

    public int getRowsAmount() {
        return this.rowsAmount;
    }

    public int getColumnsAmount() {
        return this.columnsAmount;
    }

    @Override
    public String display() {
        StringBuilder builder = new StringBuilder();
        for (var row : rowList) {
            for (var elem : row.getContent()) {
                builder.append(elem.toString()).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
