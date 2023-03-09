package edu.compmath.math_section.linear_algebra.enitities;

import edu.compmath.math_section.MathEntities;
import edu.compmath.math_section.linear_algebra.enitities.utils.Column;
import edu.compmath.math_section.linear_algebra.enitities.utils.Element;
import edu.compmath.math_section.linear_algebra.enitities.utils.Row;
import edu.compmath.utils.exceptions.matrix.InvalidMatrixSizeException;

import java.util.ArrayList;
import java.util.List;

public class Matrix extends MathEntities<Double> {

    protected final int rowsAmount;
    protected final int columnsAmount;
    protected final List<Row<Element<Double>, Double>> rowList;
    protected final List<Column<Element<Double>, Double>> columnList;

//    @SuppressWarnings("unchecked")
    public Matrix(Double[][] content, int rowsAmount, int columnsAmount) throws InvalidMatrixSizeException {
        if (rowsAmount == 0 || columnsAmount == 0) { throw new InvalidMatrixSizeException("One of the matrix's size parameters is less or equal zero."); }
        if (columnsAmount - rowsAmount != 1) { throw new InvalidMatrixSizeException("Can not define matrix's 'b' column."); }
        this.rowsAmount = rowsAmount;
        this.columnsAmount = columnsAmount;
        this.rowList = new ArrayList<>(rowsAmount);
        this.columnList = new ArrayList<>(columnsAmount);

        for (int i = 0; i < columnsAmount; i++) {columnList.add(new Column<>(rowsAmount));}
        List<Element<Double>> tempRow = new ArrayList<>(columnsAmount);

        for (int i = 0; i < rowsAmount; i++) {
            rowList.add(new Row<>(columnsAmount));
            for (int j = 0; j < columnsAmount; j++) {
                Element<Double> currentElement = new Element<>(content[i][j]);
                tempRow.add(currentElement);
                Column<Element<Double>, Double> c =  columnList.get(j);
                c.setSpecificElement(i, currentElement);
            }
            rowList.set(i, new Row<Element<Double>, Double>(List.copyOf(tempRow)));
            tempRow.clear();
        }
    }

    public Element<Double> at(int rowIndex, int columnIndex) {
        return rowList.get(rowIndex).getElementAt(columnIndex);
    }

    public Row<Element<Double>, Double> getRow(int index) {
        return rowList.get(index);
    }

    public List<Element<Double>> getRowAsList(int index) {
        return getRow(index).getContent();
    }

    public Column<Element<Double>, Double> getColumn(int index) {
        return columnList.get(index);
    }

    public List<Element<Double>> getColumnAsList(int index) {
        return getColumn(index).getContent();
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
