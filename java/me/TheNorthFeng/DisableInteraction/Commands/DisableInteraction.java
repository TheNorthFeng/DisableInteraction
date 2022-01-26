package me.TheNorthFeng.DisableInteraction.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class DisableInteraction implements CommandExecutor{
    Plugin config = me.TheNorthFeng.DisableInteraction.Main.getProvidingPlugin(me.TheNorthFeng.DisableInteraction.Main.class);
    FileConfiguration c = config.getConfig();
    String h = c.getString("Prefix");
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("disableinteraction.admin")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', h + " &c命令不完整"));
                return false;
            } else if (args.length == 1) {
                String args_to_string = args[0];
                if (args_to_string.equals("reload")) {
                    config.reloadConfig();
                    config.saveDefaultConfig();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', h + " &a插件已重载"));
                    return true;
                }
            }
        }else{
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', h + " &c你没有权限使用这条指令！"));
        }
        return true;
    }
}
