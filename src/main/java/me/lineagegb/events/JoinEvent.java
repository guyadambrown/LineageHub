package me.lineagegb.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent joinEvent){
        Player player = joinEvent.getPlayer();
        player.sendTitle("Welcome §6§l" + player.getName(),null,10,70,20);

        //Give player Creative item on join
        ItemStack CreativeItem = new ItemStack(Material.GRASS_BLOCK, 1);
        ItemMeta CreativeMeta = CreativeItem.getItemMeta();
        CreativeMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Creative " + ChatColor.DARK_GRAY + "(Right Click)");
        CreativeItem.setItemMeta(CreativeMeta);
        player.getInventory().setItem(2,CreativeItem);

        //Give player Survival item on join
        ItemStack SurvivalItem = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemMeta SurvivalMeta = SurvivalItem.getItemMeta();
        SurvivalMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Survival " + ChatColor.DARK_GRAY + "(Right Click)");
        SurvivalItem.setItemMeta(SurvivalMeta);
        player.getInventory().setItem(6,SurvivalItem);
    }
}
