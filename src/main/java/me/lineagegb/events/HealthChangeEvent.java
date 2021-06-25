package me.lineagegb.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class HealthChangeEvent implements Listener {
    @EventHandler
    public void onHealthChange(EntityDamageEvent event){
        event.setCancelled(true);
    }

    public void onHungerChange(FoodLevelChangeEvent foodLevelChangeEvent){
        foodLevelChangeEvent.setCancelled(true);
    }
}
