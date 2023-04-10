package edu.compmath.utils.managing.commands.factories.linear_algebra;

import edu.compmath.math_section.CalculactionContext;
import edu.compmath.math_section.linear_algebra.enitities.matrix.Matrix;
import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.CommandFactory;
import edu.compmath.utils.managing.commands.implementations.linear_algebra.GaussSeidelMethodCommand;
import edu.compmath.utils.managing.commands.managers.MathEntityManager;

import java.util.Map;

public class GaussSeidelMethodCommandFactory extends CommandFactory {
    private final CalculactionContext calculactionContext;
    private final MathEntityManager<Matrix> matrixManager;

    public GaussSeidelMethodCommandFactory(CalculactionContext calculactionContext, MathEntityManager<Matrix> matrixManager) {
        this.calculactionContext = calculactionContext;
        this.matrixManager = matrixManager;
        this.commandExample = new GaussSeidelMethodCommand(null, null);
    }


    @Override
    public Command create() {
        return new GaussSeidelMethodCommand(calculactionContext, matrixManager);
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
