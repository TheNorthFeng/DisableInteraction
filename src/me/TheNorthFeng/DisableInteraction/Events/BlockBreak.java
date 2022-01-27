package me.TheNorthFeng.DisableInteraction.Events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

public class BlockBreak implements Listener{
    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent e){
        Player player = e.getPlayer();
        Plugin config = me.TheNorthFeng.DisableInteraction.Main.getProvidingPlugin(me.TheNorthFeng.DisableInteraction.Main.class);
        FileConfiguration c = config.getConfig();
        String head = c.getString("Prefix");
        String message = c.getString("BlockBreakEvent.message");
        if (config.getConfig().getBoolean("BlockBreakEvent.Enable")==true){
            e.setCancelled(false);
        }
        else if (config.getConfig().getBoolean("BlockBreakEvent.Enable")==false){
            if (player.hasPermission(config.getConfig().getString("BlockBreakEvent.permission"))){
                e.setCancelled(false);
            }
            else{
                e.setCancelled(true);
                player.sendMessage(head+" "+message);
            }
        }
    }
}