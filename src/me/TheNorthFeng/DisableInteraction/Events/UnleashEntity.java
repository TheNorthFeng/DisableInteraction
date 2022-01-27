package me.TheNorthFeng.DisableInteraction.Events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerUnleashEntityEvent;
import org.bukkit.plugin.Plugin;

public class UnleashEntity implements Listener{
    @EventHandler
    public void PlayerUnleashEntityEvent(PlayerUnleashEntityEvent e){
        Player player = e.getPlayer();
        Plugin config = me.TheNorthFeng.DisableInteraction.Main.getProvidingPlugin(me.TheNorthFeng.DisableInteraction.Main.class);
        FileConfiguration c = config.getConfig();
        String head = c.getString("Prefix");
        String message = c.getString("UnleashEntityEvent.message");
        if (config.getConfig().getBoolean("UnleashEntityEvent.Enable")==true){
            e.setCancelled(false);
        }
        else if (config.getConfig().getBoolean("UnleashEntityEvent.Enable")==false){
            if (player.hasPermission(config.getConfig().getString("UnleashEntityEvent.permission"))){
                e.setCancelled(false);
            }
            else{
                e.setCancelled(true);
                player.sendMessage(head+" "+message);
            }
        }
    }
}
