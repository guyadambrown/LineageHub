package me.lineagegb.events;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.lineagegb.LineageHub;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InteractEvent implements Listener {
    @EventHandler
    public void onPlayerUse(PlayerInteractEvent interactEvent){
        Player player = interactEvent.getPlayer();
        Player proxyplayer = Bukkit.getPlayerExact(player.getName());
        if (interactEvent.getAction().equals(Action.RIGHT_CLICK_AIR)){
            //Register Survival ItemStack
            ItemStack SurvivalItem = new ItemStack(Material.IRON_PICKAXE, 1);
            ItemMeta SurvivalMeta = SurvivalItem.getItemMeta();
            SurvivalMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Survival " + ChatColor.DARK_GRAY + "(Right Click)");
            SurvivalItem.setItemMeta(SurvivalMeta);

            //Register Creative ItemStack
            ItemStack CreativeItem = new ItemStack(Material.GRASS_BLOCK, 1);
            ItemMeta CreativeMeta = CreativeItem.getItemMeta();
            CreativeMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Creative " + ChatColor.DARK_GRAY + "(Right Click)");
            CreativeItem.setItemMeta(CreativeMeta);


            if (player.getInventory().getItemInMainHand().equals(SurvivalItem)){
                //Send player to survival server
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("Connect");
                out.writeUTF("survival");
                proxyplayer.sendPluginMessage( LineageHub.getPlugin(), "BungeeCord", out.toByteArray());

            }else {
                //Send Player to creative server
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("Connect");
                out.writeUTF("creative");
                player.sendPluginMessage(LineageHub.getPlugin(), "BungeeCord", out.toByteArray());
            }
        }
    }
}
