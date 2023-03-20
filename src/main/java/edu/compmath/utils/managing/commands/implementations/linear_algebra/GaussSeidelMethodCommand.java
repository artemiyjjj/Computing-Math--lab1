package edu.compmath.utils.managing.commands.implementations.linear_algebra;

import edu.compmath.Main;
import edu.compmath.math_section.CalculactionContext;
import edu.compmath.math_section.linear_algebra.enitities.Matrix;
import edu.compmath.math_section.linear_algebra.methods.gauss_seidel.GaussSeidelBasicStrategy;
import edu.compmath.math_section.linear_algebra.methods.gauss_seidel.GaussSeidelInformativeStrategy;
import edu.compmath.math_section.linear_algebra.methods.gauss_seidel.utils.Precision;
import edu.compmath.utils.exceptions.InvalidCommandArgsException;
import edu.compmath.utils.managing.commands.Command;
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
    private final static boolean hasArgs = true;
    private CalculactionContext context;
    private Matrix matrix;

    public GaussSeidelMethodCommand(CalculactionContext context, Matrix matrix) {
        super();
        this.context = context;
        this.matrix = matrix;
    }

    public GaussSeidelMethodCommand(Matrix matrix) {
        super();
    }

    @Override
    public void execute(String[] args) {
        while (matrix == null) {
            new InsertMatrixCommand(this.matrix).execute(new String[]{}); //todo что то ругается
        }
        try {
            Precision<Double> precision = getPrecision();
            if (Arrays.asList(args).contains("i")) {
                context.setStrategy(new GaussSeidelInformativeStrategy(matrix, precision.getValue()));
            }
            else {
                context.setStrategy(new GaussSeidelBasicStrategy(matrix, precision.getValue()));
            }
            context.executeStrategy();
        } catch (IOException e) {
            Main.getWriter().write("Failed to read precision");
        }
    }

    private Precision<Double> getPrecision() throws IOException {
        Main.getWriter().write("Insert calculation precision");
        String precisionString;
        Precision<Double> precision;
        PrecisionParser precisionParser = new PrecisionParser();
        StringPrettifyParser stringPrettifyParser = new StringPrettifyParser();
        do {
            precisionString = Main.getReader().read();
            String[] handledString = stringPrettifyParser.handleLine(precisionString);
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
