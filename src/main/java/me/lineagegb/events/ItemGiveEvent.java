package me.lineagegb.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemGiveEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent joinEvent){
        
        Player player = joinEvent.getPlayer();
        //Casts the player to a Bukkit Player
        player.teleport(Bukkit.getServer().getWorld("world").getSpawnLocation());
        player.sendTitle("Welcome §6§l" + player.getName(),null,10,70,20);
        //Welcomes them to the server with a title.
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f,1f);
        //Plays a sound to them


        if (player.hasPermission("lineagehub.items.give")){
            //Give player Creative item on join
                ItemStack Creative_Item = new ItemStack(Material.GRASS_BLOCK, 1);
                ItemMeta Creative_Meta = Creative_Item.getItemMeta();
                Creative_Meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Creative " + ChatColor.DARK_GRAY + "(Right Click)");
                Creative_Item.setItemMeta(Creative_Meta);
                player.getInventory().setItem(2,Creative_Item);

                //Public survival server item
                ItemStack Survival_Item = new ItemStack(Material.IRON_PICKAXE, 1);
                ItemMeta Survival_Meta = Survival_Item.getItemMeta();
                Survival_Meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Survival " + ChatColor.DARK_GRAY + "(Right Click)");
                Survival_Item.setItemMeta(Survival_Meta);
                player.getInventory().setItem(6,Survival_Item);

        }
    }
}
