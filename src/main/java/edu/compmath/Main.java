package edu.compmath;

import edu.compmath.utils.Observer;
import edu.compmath.utils.interaction.CommandScanner;
import edu.compmath.utils.interaction.InteractionContext;
import edu.compmath.utils.interaction.InteractionStrategy;
import edu.compmath.utils.interaction.console.ConsoleInteractionStrategy;
import edu.compmath.utils.io.Reader;
import edu.compmath.utils.io.Writer;
import edu.compmath.utils.managing.Invoker;
import edu.compmath.utils.managing.CommandManagerContext;
import edu.compmath.utils.managing.commands.CommandStrategy;
import edu.compmath.utils.managing.commands.managers.*;
import edu.compmath.utils.parsers.implementations.InitialParametersParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Writer writer = null;
    private static Reader reader = null;
    private static CommandScanner commandScanner;

    private static final Map<Class<?>, InteractionStrategy> interactionStrategyMap = new HashMap<>();
    static {
        interactionStrategyMap.put(ConsoleInteractionStrategy.class, new ConsoleInteractionStrategy());
//        interactionStrategyMap.put(GUIInteractionStrategy.class, new GUIInteractionStrategy());
    }
    private static final InteractionContext interactionContext = new InteractionContext(interactionStrategyMap);

    public static Writer getWriter() {
        return writer;
    }

    public static Reader getReader() {
        return reader;
    }

    public static void setWriter(Writer writer) {
        Main.writer = writer;
    }

    public static void setReader(Reader reader) {
        Main.reader = reader;
    }

    public static CommandScanner getCommandScanner() {
        return commandScanner;
    }

    public static void setCommandScanner(CommandScanner concreteCommandScanner) {
        commandScanner = concreteCommandScanner;
    }

    public static InteractionContext getInteractionContext() {
        return interactionContext;
    }

    public static void changeInteractionContext(Class<?> interactionContextClass) {
        Main.interactionContext.setStrategy(interactionContextClass);
    }


    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nApp is stopping it's work. This is the end, beautiful friend.");
        }));

        InitialParametersParser initialParametersParser = new InitialParametersParser(interactionStrategyMap);
        interactionContext.setStrategy(initialParametersParser.parseParams(args));
        interactionContext.executeStrategy();

        CommandManagerContext commandManagerContext;
        Observer<String, CommandManager> invoker = new Invoker();

        List<Observer<String, CommandManager>> observerList = new ArrayList<>();
        {
            observerList.add(invoker);
        }

        commandManagerContext = new CommandManagerContext(observerList);

        Map<Class<?>, CommandStrategy> commandManagerStrategies = new HashMap<>();
        {
            commandManagerStrategies.put(CommonCommandStrategy.class, new CommonCommandStrategy(commandManagerContext));
            commandManagerStrategies.put(LinearAlgebraCommandStrategy.class, new LinearAlgebraCommandStrategy(commandManagerContext));
        }

        commandManagerContext.setCommandManagerStrategies(commandManagerStrategies);
        commandManagerContext.setStrategy(commandManagerStrategies.get(CommonCommandStrategy.class));


        while (true) {
            commandManagerContext.executeStrategy();
        }

    }
}