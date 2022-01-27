package me.TheNorthFeng.DisableInteraction.Events;

import me.TheNorthFeng.DisableInteraction.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.plugin.Plugin;

public class PrepareItemEnchant implements Listener{
    @EventHandler
    public void PrepareItemEnchantEvent(PrepareItemEnchantEvent e){
        Player player = e.getEnchanter();
        Plugin config = me.TheNorthFeng.DisableInteraction.Main.getProvidingPlugin(me.TheNorthFeng.DisableInteraction.Main.class);
        FileConfiguration c = config.getConfig();
        String head = c.getString("Prefix");
        String message = c.getString("PrepareItemEnchantEvent.message");
        if (config.getConfig().getBoolean("PrepareItemEnchantEvent.Enable")==true){
            e.setCancelled(false);
        }
        else if (config.getConfig().getBoolean("PrepareItemEnchantEvent.Enable")==false){
            if (player.hasPermission(config.getConfig().getString("PrepareItemEnchantEvent.permission"))){
                e.setCancelled(false);
            }
            else{
                e.setCancelled(true);
                player.sendMessage(head+" "+message);
            }
        }
    }
}
