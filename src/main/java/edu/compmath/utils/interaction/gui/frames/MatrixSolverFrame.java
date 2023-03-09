package edu.compmath.utils.interaction.gui.frames;

import edu.compmath.math_section.linear_algebra.enitities.Matrix;

import javax.swing.*;
import java.awt.GridLayout;
import java.util.List;

public class MatrixSolverFrame extends JFrame {
    private int rowElementsCount;
    private int columnElementsCount;

    private final JTextField rowElementsInput = new JTextField();
    private final JTextField columnElementsInput = new JTextField();
    private final JTextField[][] matrixElementsInput;



    public MatrixSolverFrame(int rowElementsCount, int columnElementsCount) {
        this.rowElementsCount = rowElementsCount;
        this.columnElementsCount = columnElementsCount;
        matrixElementsInput = new JTextField[rowElementsCount][columnElementsCount];

        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rowElementsCount, columnElementsCount,5,5));
        for (int i = 0; i < rowElementsCount * columnElementsCount; i++) {
            panel.add(new JButton(String.valueOf(i)));
        }
        setContentPane(panel);
        setVisible(true);
    }



    public int getRowElementsCount() {
        return rowElementsCount;
    }

    public int getColumnElementsCount() {
        return columnElementsCount;
    }

    public void setRowElementsCount(int rowElementsCount) {
        this.rowElementsCount = rowElementsCount;
    }

    public void setColumnElementsCount(int columnElementsCount) {
        this.columnElementsCount = columnElementsCount;
    }
}
