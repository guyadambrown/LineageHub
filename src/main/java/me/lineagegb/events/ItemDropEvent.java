package me.lineagegb.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropEvent implements Listener {
    @EventHandler
    public void ItemDrop(PlayerDropItemEvent dropEvent){
        Player player = (Player) dropEvent.getPlayer();
        if (!player.hasPermission("lineagehub.drop_item")){
            dropEvent.setCancelled(true);
        }
    }
}
