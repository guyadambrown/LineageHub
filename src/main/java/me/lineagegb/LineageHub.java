package me.lineagegb;

import me.lineagegb.events.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class LineageHub extends JavaPlugin {

    public static JavaPlugin plugin;

    public static JavaPlugin getPlugin(){
        return plugin;
    }
    
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "LineageHub " + ChatColor.GREEN + "Enabled");
        getServer().getPluginManager().registerEvents(new ItemGiveEvent(), this);
        getServer().getPluginManager().registerEvents(new InteractEvent(),this);
        getServer().getPluginManager().registerEvents(new PlaceEvent(),this);
        getServer().getPluginManager().registerEvents(new BreakEvent(),this);
        getServer().getPluginManager().registerEvents(new OutOfWorldEvent(),this);
        getServer().getPluginManager().registerEvents(new HealthChangeEvent(),this);
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

 
}

