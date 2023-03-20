package edu.compmath.utils.managing.commands.implementations.linear_algebra;

import edu.compmath.Main;
import edu.compmath.math_section.linear_algebra.enitities.Matrix;
import edu.compmath.utils.exceptions.InvalidCommandArgsException;
import edu.compmath.utils.exceptions.matrix.InvalidMatrixSizeException;
import edu.compmath.utils.io.Reader;
import edu.compmath.utils.io.Writer;
import edu.compmath.utils.io.readers.FileReader;
import edu.compmath.utils.managing.commands.Command;
import edu.compmath.utils.parsers.implementations.ConsoleCommandParser;
import edu.compmath.utils.parsers.implementations.PathToFileParser;
import edu.compmath.utils.parsers.implementations.PlainMatrixParser;
import edu.compmath.utils.parsers.implementations.StringPrettifyParser;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class InsertMatrixCommand extends Command {
    private final static String name = "insert_matrix";
    private final static String description = "command initializes matrix." +
            " User has to choose whether to insert matrix by manual import or" +
            " by passing the path to file with the matrix.";
    private final static Map<String, String> acceptableArgs = new HashMap<>();

    static {
        acceptableArgs.put("f", "insert matrix from existing file on the computer.");
        acceptableArgs.put("m", "manual row by row matrix insertion.");
    }

    private Matrix matrix;

    public InsertMatrixCommand(Matrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public void execute(String[] args) {
        this.args = args;
        Writer writer = Main.getWriter();

        try {
            if (this.args.length == 0) {
                this.args = new String[1];
                writer.write("Choose the way you want to insert matrix:");
                writeAcceptableArgs();
                readCommandArgument();
            }

            while (true) {
                try {
                    operateWithCommandArguments(this.args[0]);
                    break;
                } catch (InvalidCommandArgsException e) {
                    writer.write(e.getMessage());
                    writeAcceptableArgs();
                    readCommandArgument();
                } catch (Exception e) {
                    writer.write(e.getMessage()); //writeErr()
                    return;
                }
            }
        } catch (IOException e) {
            writer.write("Reading operation is broken. Restart the app.");
            return;
        }
    }

    private String readCommandArgument() throws IOException {
        ConsoleCommandParser consoleCommandParser = new ConsoleCommandParser();
        while (true) {
            String argumentLine;
            argumentLine = Main.getReader().read();
            args = StringPrettifyParser.handleLine(argumentLine);
            args = consoleCommandParser.validateArgs(args, acceptableArgs.keySet().toArray(String[]::new));
            if (args.length != 1) {
                Main.getWriter().write("Insert ONE argument of the list:"); // writeErr()
                writeAcceptableArgs();
                continue;
            }
            return args[0];
        }
    }

    private String[] readElementsLine() throws IOException {
        String readString = Main.getReader().read();
        return StringPrettifyParser.handleLine(readString);
    }

    private void writeAcceptableArgs() {
        for (Map.Entry<String, String> entryArgs : acceptableArgs.entrySet()) {
            Main.getWriter().write("\t\t-" + entryArgs.getKey() + " — " + entryArgs.getValue());
        }
    }

    private void operateWithCommandArguments(String arg) throws InvalidCommandArgsException, InvalidMatrixSizeException, IOException {
        Writer writer = Main.getWriter();
        Reader reader = Main.getReader();
        PlainMatrixParser matrixParser = new PlainMatrixParser();
        switch (arg) {
            case "f" -> {
                String pathString;
                Optional<Path> pathToFile;
                do {
                    writer.write("Insert absolute or relative to current directory ("
                            + Paths.get("") + ") path to file with matrix:");
                    pathString = reader.read();
                    pathToFile = PathToFileParser.resolvePath(pathString);
                }
                while (pathToFile.isEmpty());

                List<String> fileLines = FileReader.readAllLines(pathToFile.get());
                List<String[]> rowsList = fileLines.stream().map(StringPrettifyParser::handleLine).collect(Collectors.toList());
                matrix = matrixParser.parseEntity(rowsList);
                matrix.display();
            }

            case "m" -> {
                writer.write("Insert matrix with rows separated by new line(Enter) and elemens separated by \" \"(space).");
                writer.write("To end up inserting, tap Enter once again.");
                List<String[]> rowList = new ArrayList<>();
                String[] newLine;
                for (; ; ) {
                    newLine = readElementsLine();
                    if (!newLine[0].equals("")) {
                        rowList.add(newLine);
                    } else {
                        break;
                    }
                }
                matrix = matrixParser.parseEntity(rowList);
                matrix.display();
            }

            default -> throw new InvalidCommandArgsException("Inserted argument is not acceptable.");
        }
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
