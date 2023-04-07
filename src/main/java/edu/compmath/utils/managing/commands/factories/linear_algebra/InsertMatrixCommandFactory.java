package edu.compmath.utils.managing.commands.factories.linear_algebra;

import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.CommandFactory;
import edu.compmath.utils.managing.commands.implementations.linear_algebra.InsertMatrixCommand;
import edu.compmath.utils.managing.commands.managers.MatrixManager;

import java.util.Map;

public class InsertMatrixCommandFactory extends CommandFactory {
    private final MatrixManager matrixManager;

    public InsertMatrixCommandFactory(MatrixManager matrixManager) {
        this.matrixManager = matrixManager;
        this.commandExample = new InsertMatrixCommand(null);
    }


    @Override
    public Command create() {
        return new InsertMatrixCommand(matrixManager);
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
