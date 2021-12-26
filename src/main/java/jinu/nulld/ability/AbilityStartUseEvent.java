package jinu.nulld.ability;

import jinu.nulld.jobs.Jobs;
import org.bukkit.event.HandlerList;

public class AbilityStartUseEvent extends AbilityEvent{
    private static final HandlerList handlers = new HandlerList();

    public AbilityStartUseEvent(Jobs job) {
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
