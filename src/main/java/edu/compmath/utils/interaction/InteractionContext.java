package edu.compmath.utils.interaction;

import edu.compmath.utils.Context;
import edu.compmath.utils.interaction.console.ConsoleInteractionStrategy;

import java.util.Map;

public class InteractionContext extends Context {
    private final Map<Class<?>, InteractionStrategy> interactionStrategyMap;

    public InteractionContext(Map<Class<?>, InteractionStrategy> interactionStrategyMap) {
        super(interactionStrategyMap.get(ConsoleInteractionStrategy.class));
        this.interactionStrategyMap = interactionStrategyMap;
    }

    public void setStrategy(Class<?> strategyClass) {
        InteractionStrategy strategy = interactionStrategyMap.get(strategyClass);
        if (strategy != null) {
            super.strategy = strategy;
        }
    }
}
