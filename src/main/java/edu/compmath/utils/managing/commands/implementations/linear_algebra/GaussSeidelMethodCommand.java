package edu.compmath.utils.managing.commands.implementations.linear_algebra;

import edu.compmath.Main;
import edu.compmath.math_section.CalculactionContext;
import edu.compmath.math_section.linear_algebra.methods.gauss_seidel.strategies.GaussSeidelBasicStrategy;
import edu.compmath.math_section.linear_algebra.methods.gauss_seidel.strategies.GaussSeidelInformativeStrategy;
import edu.compmath.math_section.linear_algebra.methods.gauss_seidel.utils.Precision;
import edu.compmath.utils.exceptions.InvalidCommandArgsException;
import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.managing.commands.managers.MatrixManager;
import edu.compmath.utils.parsers.implementations.ConsoleCommandParser;
import edu.compmath.utils.parsers.implementations.PrecisionParser;
import edu.compmath.utils.parsers.implementations.StringPrettifyParser;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GaussSeidelMethodCommand extends Command {
    private final static String name = "gauss_seidel";
    private final static String description = "command initializes matrix if it isn't and solves it with Gauss-Seidel method, returns solution of the matrix equations.";
    private final static Map<String, String> acceptableArgs = new HashMap<>();
    static {
        acceptableArgs.put("i", "shows each iteration's result.");
        acceptableArgs.put(null, "not informative way of executing.");
    }
    private final CalculactionContext context;
    private final MatrixManager matrixManager;

    public GaussSeidelMethodCommand(CalculactionContext context, MatrixManager matrixManager) {
        super();
        this.context = context;
        this.matrixManager = matrixManager;
    }

    @Override
    public void execute(String[] args) {
        ConsoleCommandParser consoleCommandParser = new ConsoleCommandParser();
        while (matrixManager.getEntity() == null) {
            new InsertMatrixCommand(this.matrixManager).execute(new String[]{});
        }
        try {
            Precision<Double> precision = getPrecision();
            args = consoleCommandParser.validateArgs(args, acceptableArgs.keySet().toArray(String[]::new));
            if (Arrays.asList(args).contains("i")) {
                context.setStrategy(new GaussSeidelInformativeStrategy(matrixManager.getEntity(), precision.getValue()));
            }
            else {
                context.setStrategy(new GaussSeidelBasicStrategy(matrixManager.getEntity(), precision.getValue()));
            }
            context.executeStrategy();
        } catch (IOException e) {
            Main.getWriter().write("Failed to read precision.");
        }
    }

    private Precision<Double> getPrecision() throws IOException {
        String precisionString;
        Precision<Double> precision;
        PrecisionParser precisionParser = new PrecisionParser();
        do {
            Main.getWriter().write("Insert calculation precision");
            precisionString = Main.getReader().read();
            String[] handledString = StringPrettifyParser.handleLine(precisionString);
            try {
                precision = precisionParser.argumentParse(handledString);
                break;
            } catch (InvalidCommandArgsException e) {
                continue;
            }
        }
        while (true);
        return precision;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Map<String, String> getAcceptableArgs() {
        return acceptableArgs;
    }
}
