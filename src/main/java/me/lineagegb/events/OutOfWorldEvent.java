package me.lineagegb.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class OutOfWorldEvent implements Listener {
    @EventHandler
    public void OnOutOfWorld(PlayerMoveEvent moveEvent){
        Player player = moveEvent.getPlayer();
        if(!player.hasPermission("lineagehub.outofworld")){
            if (player.getLocation().getBlockY() <60){
                Location spawn = new Location(player.getWorld(), 0,64,0);
                player.teleport(spawn);
                player.sendMessage("§6§lCrunchy§f§lCraft§8 » §rOops, you slipped.");
        }
        }
    }
}
