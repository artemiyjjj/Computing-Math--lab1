package edu.compmath.utils.interaction;

import edu.compmath.utils.Context;
import edu.compmath.utils.interaction.console.ConsoleInteractionStrategy;
import edu.compmath.utils.interaction.gui.GUIInteractionStrategy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InteractionContext extends Context {
    private InteractionStrategy interactionStrategy;

    private final Map<Class<?>, InteractionStrategy> interactionStrategyMap = new HashMap<>();
    {
        interactionStrategyMap.put(ConsoleInteractionStrategy.class, new ConsoleInteractionStrategy());
        interactionStrategyMap.put(GUIInteractionStrategy.class, new GUIInteractionStrategy());
    }

    public InteractionContext() {}

    @Override
    public void executeStrategy() throws IOException {
        this.interactionStrategy.execute();
    }

    public InteractionStrategy getInteractionStrategy() {
        return this.interactionStrategy;
    }

    public void changeStrategy(Class<?> strategyClass) {
        InteractionStrategy strategy = interactionStrategyMap.get(strategyClass);
        if (strategy != null) {
            this.interactionStrategy = strategy;
        }
    }
}
