package edu.compmath.utils.managing.commands.managers;

import edu.compmath.math_section.CalculactionContext;
import edu.compmath.math_section.linear_algebra.LinearAlgebraSolver;
import edu.compmath.utils.managing.CommandManagerContext;
import edu.compmath.utils.managing.commands.CommandFactory;
import edu.compmath.utils.managing.commands.factories.common.HelpCommandFactory;
import edu.compmath.utils.managing.commands.factories.context_changers.ChangeToCommonCommandFactory;
import edu.compmath.utils.managing.commands.factories.linear_algebra.DisplayMatrixCommandFactory;
import edu.compmath.utils.managing.commands.factories.linear_algebra.GaussSeidelMethodCommandFactory;
import edu.compmath.utils.managing.commands.factories.linear_algebra.InsertMatrixCommandFactory;

public class LinearAlgebraCommandManager extends CommandManager {
    private final MatrixManager matrixManager = new MatrixManager();
    private CalculactionContext calculactionContext = new LinearAlgebraSolver<Double>(); // этот контекст может в будущем меняться

    public LinearAlgebraCommandManager(CommandManagerContext commandManagerContext) {
        super();
        CommandFactory[] commandFactories = new CommandFactory[]{
                new HelpCommandFactory(this),
                new GaussSeidelMethodCommandFactory(calculactionContext, matrixManager),
                new InsertMatrixCommandFactory(matrixManager),
                new DisplayMatrixCommandFactory(matrixManager),
                new ChangeToCommonCommandFactory(commandManagerContext)
        };
        registerCommands(commandFactories);
    }
}
