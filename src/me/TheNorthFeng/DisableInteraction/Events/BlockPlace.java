package me.TheNorthFeng.DisableInteraction.Events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

public class BlockPlace implements Listener{
    @EventHandler
    public void BlockPlaceEvent(BlockPlaceEvent e){
        Player player = e.getPlayer();
        Plugin config = me.TheNorthFeng.DisableInteraction.Main.getProvidingPlugin(me.TheNorthFeng.DisableInteraction.Main.class);
        FileConfiguration c = config.getConfig();
        String head = c.getString("Prefix");
        String message = c.getString("BlockPlaceEvent.message");
        if (config.getConfig().getBoolean("BlockPlaceEvent.Enable")==true){
            e.setCancelled(false);
        }
        else if (config.getConfig().getBoolean("BlockPlaceEvent.Enable")==false){
            if (player.hasPermission(config.getConfig().getString("BlockPlaceEvent.permission"))){
                e.setCancelled(false);
            }
            else{
                e.setCancelled(true);
                player.sendMessage(head+" "+message);
            }
        }
    }
}