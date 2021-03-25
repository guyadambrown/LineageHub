package me.lineagegb.events;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceEvent implements Listener {
    @EventHandler
    public void OnBlockBreak(BlockPlaceEvent placeEvent){
        Player player = (Player) placeEvent.getPlayer();
        if (!player.hasPermission("lineagehub.canmodify")){
            placeEvent.setCancelled(true);
            player.sendActionBar(TextComponent.fromLegacyText("§3§lYou cannot place blocks here!"));
        }
    }
}
