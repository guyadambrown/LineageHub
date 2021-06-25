package me.lineagegb.events;

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
        player.sendTitle("Welcome §6§l" + player.getName(),null,10,70,20);
        //Welcomes them to the server with a title.
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f,1f);
        //Plays a sound to them

        //Give player Creative item on join
        if (player.hasPermission("lineagehub.private")){
            ItemStack Creative_Private_Item = new ItemStack(Material.GRASS_BLOCK, 1);
            ItemMeta Creative_Private_Meta = Creative_Private_Item.getItemMeta();
            Creative_Private_Meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Creative Private " + ChatColor.DARK_GRAY + "(Right Click)");
            Creative_Private_Item.setItemMeta(Creative_Private_Meta);
            player.getInventory().setItem(2,Creative_Private_Item);

            //Give player Survival item on join
            ItemStack Survival_Private_Item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
            ItemMeta Survival_Private_Meta = Survival_Private_Item.getItemMeta();
            Survival_Private_Meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Survival Private " + ChatColor.DARK_GRAY + "(Right Click)");
            Survival_Private_Item.setItemMeta(Survival_Private_Meta);
            player.getInventory().setItem(6,Survival_Private_Item);
        }

        //Public survival server item
        ItemStack Survival_Item = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemMeta Survival_Meta = Survival_Item.getItemMeta();
        Survival_Meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Survival " + ChatColor.DARK_GRAY + "(Right Click)");
        Survival_Item.setItemMeta(Survival_Meta);
        player.getInventory().setItem(4,Survival_Item);

    }
}
