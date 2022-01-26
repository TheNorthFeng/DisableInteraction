package me.TheNorthFeng.DisableInteraction;

import me.TheNorthFeng.DisableInteraction.Commands.DisableInteraction;
import me.TheNorthFeng.DisableInteraction.Events.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        int pluginId = 14061;
        Metrics metrics = new Metrics(this, pluginId);
        getLogger().info(ChatColor.GREEN+"插件已加载 作者：北风_TheNorthFeng");
        getConfig().options().copyDefaults();
        this.saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new Chat(),this);
        Bukkit.getPluginManager().registerEvents(new BedEnter(),this);
        Bukkit.getPluginManager().registerEvents(new Bucket(),this);
        Bukkit.getPluginManager().registerEvents(new CommandPreprocess(),this);
        Bukkit.getPluginManager().registerEvents(new DropItem(),this);
        Bukkit.getPluginManager().registerEvents(new EditBook(),this);
        Bukkit.getPluginManager().registerEvents(new Fish(),this);
        Bukkit.getPluginManager().registerEvents(new GameModeChange(),this);
        Bukkit.getPluginManager().registerEvents(new Interact(),this);
        Bukkit.getPluginManager().registerEvents(new ItemConsume(),this);
        Bukkit.getPluginManager().registerEvents(new ItemHeld(),this);
        Bukkit.getPluginManager().registerEvents(new Kick(),this);
        Bukkit.getPluginManager().registerEvents(new Move(),this);
        Bukkit.getPluginManager().registerEvents(new ShearEntity(),this);
        Bukkit.getPluginManager().registerEvents(new ToggleSneak(),this);
        Bukkit.getPluginManager().registerEvents(new ToggleSprint(),this);
        Bukkit.getPluginManager().registerEvents(new ToggleFlight(),this);
        Bukkit.getPluginManager().registerEvents(new UnleashEntity(),this);
        Bukkit.getPluginManager().registerEvents(new Velocity(),this);
        getCommand("DisableInteraction").setExecutor(new DisableInteraction());
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.GREEN+"插件已卸载 作者：北风_TheNorthFeng");
        this.saveDefaultConfig();
    }
}
