package jinu.nulld.flow;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nullable;
import java.util.Map;

public class JudgeEndEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final String target;


    public JudgeEndEvent(String target) {
        this.target = target;
    }

    @Nullable
    public String getTarget(){
        return this.target;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
