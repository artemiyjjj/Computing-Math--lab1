package edu.compmath.utils.interaction.gui.frames;

import javax.swing.*;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

public class MatrixSolverFrame extends AppFrame {
    private static final int MIN_ROW_COUNT = 0;
    private static final int MAX_ROW_COUNT = 20;
    private static final int MIN_COLUMN_COUNT = 0;
    private static final int MAX_COLUMN_COUNT = 20;

    private int rowElementsCount = 0;
    private int columnElementsCount = 0;

    private final JPanel panel = new JPanel();
    private final JTextField rowElementsInput = new JTextField();
    private final JTextField columnElementsInput = new JTextField();
    private final List<List<JTextField>> matrixElementsInput = new ArrayList<>();


    public MatrixSolverFrame(int rowElementsCount, int columnElementsCount) {
        initFrame();
        this.rowElementsCount = rowElementsCount;
        this.columnElementsCount = columnElementsCount;

        for (int i = 0; i < rowElementsCount * columnElementsCount; i++) {
            panel.add(new JButton(String.valueOf(i)));
        }
    }

    public MatrixSolverFrame() {

    }

    private void initFrame() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(rowElementsCount, columnElementsCount, 5, 5));
        setContentPane(panel);
        setVisible(true);
    }

    private void changeVisibleColumnCount(int columnCount) {

    }

    private void changeVisibleRowCount(int rowCount) {


    }

    private boolean isCountValid(int amountOfElements) {
// throw exeptions and set text to JText of the latest input
        return true;
    }


    public int getRowElementsCount() {
        return rowElementsCount;
    }

    public int getColumnElementsCount() {
        return columnElementsCount;
    }

    public void setRowElementsCount(int rowElementsCount) {
        if (isCountValid(rowElementsCount)) {
            this.rowElementsCount = rowElementsCount;
            changeVisibleRowCount(rowElementsCount);
        }
        }

        public void setColumnElementsCount (int columnElementsCount){
            if (isCountValid(columnElementsCount)) {
                this.columnElementsCount = columnElementsCount;
                changeVisibleColumnCount(columnElementsCount);
            }
        }
    }
