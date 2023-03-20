package edu.compmath.utils.managing.commands.factories.linear_algebra;

import edu.compmath.math_section.linear_algebra.enitities.Matrix;
import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.CommandFactory;
import edu.compmath.utils.managing.commands.implementations.linear_algebra.DisplayMatrixCommand;

import java.util.Map;

public class DisplayMatrixCommandFactory extends CommandFactory {

    private Matrix matrix;

    public DisplayMatrixCommandFactory(Matrix matrix) {
        this.matrix = matrix;
        this.commandExample = new DisplayMatrixCommand(null);
    }

    @Override
    public Command create() {
        return new DisplayMatrixCommand(matrix);
    }

    @Override
    public String getCommandName() {
        return this.commandExample.getName();
    }

    @Override
    public String getCommandDescription() {
        return this.commandExample.getDescription();
    }

    @Override
    public Map<String, String> getCommandAcceptableArgs() {
        return this.commandExample.getAcceptableArgs();
    }
}
