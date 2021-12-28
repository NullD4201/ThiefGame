package jinu.nulld.flow;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GameStateChangeEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final GameState oldState;
    private final GameState newState;

    private boolean isCancelled;

    public GameStateChangeEvent(GameState oldState, GameState newState){
        this.oldState = oldState;
        this.newState = newState;
    }

    public GameState getOldState(){ return this.oldState; }
    public GameState getNewState() { return this.newState; }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
