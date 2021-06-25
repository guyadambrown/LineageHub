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
            ItemStack Survival_Private_Item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
            ItemMeta Survival_Private_Meta = Survival_Private_Item.getItemMeta();
            Survival_Private_Meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Survival Private" + ChatColor.DARK_GRAY + "(Right Click)");
            Survival_Private_Item.setItemMeta(Survival_Private_Meta);

            //Register Creative ItemStack
            ItemStack Creative_Private_Item = new ItemStack(Material.GRASS_BLOCK, 1);
            ItemMeta Creative_Private_Meta = Creative_Private_Item.getItemMeta();
            Creative_Private_Meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Creative Private" + ChatColor.DARK_GRAY + "(Right Click)");
            Creative_Private_Item.setItemMeta(Creative_Private_Meta);

            //Register Survival ItemStack
            ItemStack Survival_Item = new ItemStack(Material.IRON_PICKAXE, 1);
            ItemMeta Survival_Meta = Survival_Item.getItemMeta();
            Survival_Meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Survival" + ChatColor.DARK_GRAY + "(Right Click)");
            Survival_Private_Item.setItemMeta(Survival_Meta);



            if (player.getInventory().getItemInMainHand().equals(Survival_Private_Item)) {
                //Send player to survival server
                if (player.hasPermission("lineagehub.private")){
                    ByteArrayDataOutput out = ByteStreams.newDataOutput();
                    out.writeUTF("Connect");
                    out.writeUTF("survival-private");
                    proxyplayer.sendPluginMessage(LineageHub.getPlugin(), "BungeeCord", out.toByteArray());

                }
            }


            if (player.getInventory().getItemInMainHand().equals(Creative_Private_Item)){
                //Send Player to creative server
                if (player.hasPermission("lineagehub.private")){

                    ByteArrayDataOutput out = ByteStreams.newDataOutput();
                    out.writeUTF("Connect");
                    out.writeUTF("creative-private");
                    player.sendPluginMessage(LineageHub.getPlugin(), "BungeeCord", out.toByteArray());
                }
            }

            if (player.getInventory().getItemInMainHand().equals(Survival_Item)){
                    ByteArrayDataOutput out = ByteStreams.newDataOutput();
                    out.writeUTF("Connect");
                    out.writeUTF("survival");
                    player.sendPluginMessage(LineageHub.getPlugin(), "BungeeCord", out.toByteArray());
                }

            }
            }
        }
