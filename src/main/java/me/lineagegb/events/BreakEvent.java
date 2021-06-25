package me.lineagegb.events;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerHarvestBlockEvent;

public class BreakEvent implements Listener {
    @EventHandler
    public void OnPlayerModify(BlockBreakEvent breakEvent){
        Player player = breakEvent.getPlayer();
        if (!player.hasPermission("lineagehub.canmodify")){
            breakEvent.setCancelled(true);
            player.sendActionBar(TextComponent.fromLegacyText("§3§lYou cannot brake blocks here!"));
        }
    }
}
