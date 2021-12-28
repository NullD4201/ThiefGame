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

    /**
     * 바뀌기 이전의 State를 구합니다.
     * @return 바뀌기 이전 GameState
     */
    public GameState getOldState(){ return this.oldState; }

    /**
     * 바뀐 뒤의 State를 구합니다.
     * @return 바뀐 뒤의 GameState
     */
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
