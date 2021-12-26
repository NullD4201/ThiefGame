package jinu.nulld.ability;

import jinu.nulld.jobs.Jobs;
import org.bukkit.event.HandlerList;

public class AbilityEndUseEvent extends AbilityEvent {
    private static final HandlerList handlers = new HandlerList();

    public AbilityEndUseEvent(Jobs job) {
        super(job);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
