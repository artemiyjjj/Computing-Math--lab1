package edu.compmath.utils.managing;

import edu.compmath.utils.Observable;
import edu.compmath.utils.Observer;
import edu.compmath.utils.managing.commands.CommandContext;
import edu.compmath.utils.managing.commands.CommandStrategy;
import edu.compmath.utils.managing.commands.managers.CommandManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class defines which CommandManagerContext is executive and which CommandManager is active
 */
public class CommandManagerContext extends CommandContext implements Observable<String, CommandManager> {
    private final Map<Class<?>, CommandStrategy> commandManagerStrategies;
    private final List<Observer<String, CommandManager>> observers = new ArrayList<>();
    private CommandManager activeCommandManager;

    public CommandManagerContext(Map<Class<?>, CommandStrategy> commandManagerStrategies, CommandStrategy strategy) {
        super(strategy);
        this.activeCommandManager = strategy.getCommandManager();
        this.commandManagerStrategies = commandManagerStrategies;

        for (CommandStrategy commandStrategy : commandManagerStrategies.values()) {
            commandStrategy.setObservable(this);
        }
        notifyObserversOfUpdate(new CommandManager[]{activeCommandManager});
    }

    public void changeStrategy(Class<?> strategyClass) {
        CommandStrategy strategy = commandManagerStrategies.get(strategyClass);
        if (strategy != null && !strategy.equals(this.strategy)) {
            this.strategy = strategy;
            this.activeCommandManager = strategy.getCommandManager();
            notifyObserversOfUpdate(new CommandManager[]{this.activeCommandManager});
        } else throw new IllegalArgumentException("Unexpected call with CommandStrategy what isn't registered");
    }


    @Override
    public void notifyObserversOfUpdate(CommandManager[] commandManagers) {
        for (var observer : observers) {
            observer.notifyOfUpdate(new CommandManager[]{activeCommandManager});
        }
    }

    @Override
    public void notifyObserversOfExecution(String[] nameAndArgs) {
        for (var observer : observers) {
            observer.notifyOfExecution(nameAndArgs);
        }
    }

    @Override
    public void removeObserver(Observer<String, CommandManager> observer) {
        this.observers.remove(observer);
    }

    @Override
    public void addObserver(Observer<String, CommandManager> observer) {
        this.observers.add(observer);
    }

    public Map<Class<?>, CommandStrategy> getCommandManagerStrategies() {
        return commandManagerStrategies;
    }
}
