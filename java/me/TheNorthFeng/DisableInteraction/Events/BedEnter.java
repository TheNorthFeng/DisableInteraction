package me.TheNorthFeng.DisableInteraction.Events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.plugin.Plugin;

public class BedEnter implements Listener{
    @EventHandler
    public void PlayerBedEnterEvent(PlayerBedEnterEvent e){
        Player player = e.getPlayer();
        Plugin config = me.TheNorthFeng.DisableInteraction.Main.getProvidingPlugin(me.TheNorthFeng.DisableInteraction.Main.class);
        FileConfiguration c = config.getConfig();
        String head = c.getString("Prefix");
        String message = c.getString("BedEnterEvent.message");
        if (config.getConfig().getBoolean("BedEnterEvent.Enable")==true){
            e.setCancelled(false);
        }
        else if (config.getConfig().getBoolean("BedEnterEvent.Enable")==false){
            if (player.hasPermission(config.getConfig().getString("BedEnterEvent.permission"))){
                e.setCancelled(false);
            }
            else{
                e.setCancelled(true);
                player.sendMessage(head+" "+message);
            }
        }
    }
}
