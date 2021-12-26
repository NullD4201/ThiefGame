package jinu.nulld.ability;

import jinu.nulld.jobs.Jobs;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

public abstract class AbilityEvent extends Event implements Cancellable {
    private Jobs jobType;
    private boolean isCancelled;

    public AbilityEvent(Jobs job){
        this.isCancelled = false;
        this.jobType = job;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }

    public Jobs getJobType() { return jobType; }
}
