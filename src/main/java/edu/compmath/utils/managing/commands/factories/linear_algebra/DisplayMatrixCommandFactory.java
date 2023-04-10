package edu.compmath.utils.managing.commands.factories.linear_algebra;

import edu.compmath.math_section.linear_algebra.enitities.matrix.Matrix;
import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.CommandFactory;
import edu.compmath.utils.managing.commands.implementations.linear_algebra.DisplayMatrixCommand;
import edu.compmath.utils.managing.commands.managers.MathEntityManager;

import java.util.Map;

public class DisplayMatrixCommandFactory extends CommandFactory {

    private final MathEntityManager<Matrix> matrixManager;

    public DisplayMatrixCommandFactory(MathEntityManager<Matrix> matrixManager) {
        this.matrixManager = matrixManager;
        this.commandExample = new DisplayMatrixCommand(null);
    }

    @Override
    public Command create() {
        return new DisplayMatrixCommand(matrixManager);
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
