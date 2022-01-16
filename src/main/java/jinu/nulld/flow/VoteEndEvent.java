package jinu.nulld.flow;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.ArrayList;
import java.util.List;

public abstract class VoteEndEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private List<String> result;

    public VoteEndEvent() {
        this.result = new ArrayList<>();
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> resultList) {
        this.result = resultList;
    }
}
