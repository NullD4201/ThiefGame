package jinu.nulld.flow;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import java.util.Map;

public class ResultShowEndEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private Map<String, Integer> map;

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public ResultShowEndEvent(Map<String, Integer> map) {
        this.map = map;
    }

    public Map<String, Integer> getMap() { return map; }
}
