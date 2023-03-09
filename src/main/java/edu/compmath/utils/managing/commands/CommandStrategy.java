package edu.compmath.utils.managing.commands;

import edu.compmath.utils.Observable;
import edu.compmath.utils.Strategy;
import edu.compmath.utils.managing.commands.managers.CommandManager;

public abstract class CommandStrategy implements Strategy {
     protected final CommandManager commandManager;
     protected Observable<String, CommandManager> observable;

     public CommandStrategy(CommandManager commandManager) {
          this.commandManager = commandManager;
     }

     public abstract CommandManager getCommandManager();

     public void setObservable(Observable<String, CommandManager> observable) {
          this.observable = observable;
     }

}
