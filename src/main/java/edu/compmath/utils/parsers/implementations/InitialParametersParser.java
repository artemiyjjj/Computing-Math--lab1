package edu.compmath.utils.parsers.implementations;

import edu.compmath.utils.Strategy;
import edu.compmath.utils.interaction.InteractionContext;
import edu.compmath.utils.interaction.InteractionStrategy;
import edu.compmath.utils.interaction.console.ConsoleInteractionStrategy;
import edu.compmath.utils.interaction.gui.GUIInteractionStrategy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InitialParametersParser {
    private final Map<String, InteractionStrategy> strategyMap;

    public InitialParametersParser() {
        strategyMap = new HashMap<>();
        registerStrategy("g", new GUIInteractionStrategy());
        registerStrategy(null, new ConsoleInteractionStrategy());
    }

    private void registerStrategy(String key, InteractionStrategy strategy) {
        this.strategyMap.put(key, strategy);
    }

    public InteractionStrategy parseParams(String[] args) {
        InteractionStrategy defaultStrategy = strategyMap.get(null);
        if (args.length == 0) { return defaultStrategy; }
        int i = 0;
        Set<Strategy> foundStrategies = new HashSet<>();
        for (var arg : args) {
            Strategy foundStrategy = strategyMap.get(arg);
            if (foundStrategy != null) {
                foundStrategies.add(foundStrategy);
            }
        }
        // add mixed strategies
        if (!foundStrategies.isEmpty()) {
            return (InteractionStrategy) foundStrategies.toArray()[0];
        }
        else {
            System.out.println("Some strange arguments for program executing.");
            return defaultStrategy;
        }
    }

}
