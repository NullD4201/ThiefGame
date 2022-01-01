package jinu.nulld;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class EventManager implements Listener {

    @EventHandler
    public void onFood(FoodLevelChangeEvent event){
        event.setFoodLevel(20);
    }

    @EventHandler
    public void onLeavesDecay(LeavesDecayEvent event){
        event.setCancelled(true);
    }

}
