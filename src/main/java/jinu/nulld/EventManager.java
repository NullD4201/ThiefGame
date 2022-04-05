package jinu.nulld;

import jinu.nulld.jobs.JobAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventManager implements Listener {

    @EventHandler
    public void onFood(FoodLevelChangeEvent event){
        event.setFoodLevel(20);
    }

    @EventHandler
    public void onLeavesDecay(LeavesDecayEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        if(JobAPI.getJob(p) != null){
            JobAPI.getJob(p).helmet(p);
        }
    }

}
