package edu.compmath.methods.linear_algebra.enitities;

import edu.compmath.methods.MathEntities;
import edu.compmath.methods.linear_algebra.enitities.utils.Column;
import edu.compmath.methods.linear_algebra.enitities.utils.Element;
import edu.compmath.methods.linear_algebra.enitities.utils.Row;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Matrix<T extends Number> extends MathEntities<T> {
    protected final List<Row<Element<T>, T>> rows;
    protected final List<Column<Element<T>,T>> columns;

//    @SuppressWarnings("unchecked")
    public Matrix(T[][] content, int rowsAmount, int columnsAmount) {
        this.rows = new ArrayList<>(rowsAmount);
        this.columns = new ArrayList<>(columnsAmount);
        List<Element<T>> temp = new ArrayList<>(columnsAmount);

        for (int i = 0; i < rowsAmount; i++) {
            for (int j = 0; j < columnsAmount; j++) {
                temp.add(new Element<>(content[i][j]));
            }
            rows.set(i, new Row<Element<T>, T>(temp.toArray()));
        }
    }

    private

    public T at(int row, int column) {
        return content[row][column];
    }

    public T[] getRow(int index) {

    }
}
