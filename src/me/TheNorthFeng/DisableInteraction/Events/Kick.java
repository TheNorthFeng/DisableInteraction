package me.TheNorthFeng.DisableInteraction.Events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.plugin.Plugin;

public class Kick implements Listener{
    @EventHandler
    public void PlayerKickEvent(PlayerKickEvent e){
        Player player = e.getPlayer();
        Plugin config = me.TheNorthFeng.DisableInteraction.Main.getProvidingPlugin(me.TheNorthFeng.DisableInteraction.Main.class);
        FileConfiguration c = config.getConfig();
        String head = c.getString("Prefix");
        String message = c.getString("KickEvent.message");
        if (config.getConfig().getBoolean("KickEvent.Enable")==true){
            e.setCancelled(false);
        }
        else if (config.getConfig().getBoolean("KickEvent.Enable")==false){
            if (player.hasPermission(config.getConfig().getString("KickEvent.permission"))){
                e.setCancelled(false);
            }
            else{
                e.setCancelled(true);
                player.sendMessage(head+" "+message);
            }
        }
    }
}
