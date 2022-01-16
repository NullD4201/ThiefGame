package jinu.nulld.flow;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.ArrayList;
import java.util.List;

public class VoteEndEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private List<String> result;

    public VoteEndEvent() {
        this.result = new ArrayList<>();
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> resultList) {
        this.result = resultList;
    }
}
