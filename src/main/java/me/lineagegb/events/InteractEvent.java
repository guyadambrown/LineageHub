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

            //Register Creative ItemStack
            ItemStack Creative_Item = new ItemStack(Material.GRASS_BLOCK, 1);
            ItemMeta Creative_Meta = Creative_Item.getItemMeta();
            Creative_Meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Creative " + ChatColor.DARK_GRAY + "(Right Click)");
            Creative_Item.setItemMeta(Creative_Meta);

            //Register Survival ItemStack
            ItemStack Survival_Item = new ItemStack(Material.IRON_PICKAXE, 1);
            ItemMeta Survival_Meta = Survival_Item.getItemMeta();
            Survival_Meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Survival " + ChatColor.DARK_GRAY + "(Right Click)");
            Survival_Item.setItemMeta(Survival_Meta);


            if (player.getInventory().getItemInMainHand().equals(Creative_Item)){
                //Send Player to creative server
                    ByteArrayDataOutput out = ByteStreams.newDataOutput();
                    out.writeUTF("Connect");
                    out.writeUTF("creative");
                    player.sendPluginMessage(LineageHub.getPlugin(), "BungeeCord", out.toByteArray());
            }

            if (player.getInventory().getItemInMainHand().equals(Survival_Item)){
                //send player to survival server
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("Connect");
                out.writeUTF("survival");
                player.sendPluginMessage(LineageHub.getPlugin(), "BungeeCord", out.toByteArray());
            }

        }
    }
}
