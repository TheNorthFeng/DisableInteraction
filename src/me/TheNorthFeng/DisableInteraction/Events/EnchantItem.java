package me.TheNorthFeng.DisableInteraction.Events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.plugin.Plugin;

public class EnchantItem implements Listener{
    @EventHandler
    public void EnchantItemEvent(EnchantItemEvent e){
        Player player = e.getEnchanter();
        Plugin config = me.TheNorthFeng.DisableInteraction.Main.getProvidingPlugin(me.TheNorthFeng.DisableInteraction.Main.class);
        FileConfiguration c = config.getConfig();
        String head = c.getString("Prefix");
        String message = c.getString("EnchantItemEvent.message");
        if (config.getConfig().getBoolean("EnchantItemEvent.Enable")==true){
            e.setCancelled(false);
        }
        else if (config.getConfig().getBoolean("EnchantItemEvent.Enable")==false){
            if (player.hasPermission(config.getConfig().getString("EnchantItemEvent.permission"))){
                e.setCancelled(false);
            }
            else{
                e.setCancelled(true);
                player.sendMessage(head+" "+message);
            }
        }
    }
}
