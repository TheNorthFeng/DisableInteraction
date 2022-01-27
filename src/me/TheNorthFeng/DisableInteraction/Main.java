package me.TheNorthFeng.DisableInteraction;

import me.TheNorthFeng.DisableInteraction.Commands.DisableInteraction;
import me.TheNorthFeng.DisableInteraction.Events.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main plugin;
    @Override
    public void onEnable() {
        plugin = this;
        int pluginId = 14061;
        Metrics metrics = new Metrics(this, pluginId);
        getLogger().info(ChatColor.GREEN+"插件已加载 作者：北风_TheNorthFeng");
        this.saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new Chat(),this);
        Bukkit.getPluginManager().registerEvents(new BedEnter(),this);
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
        Bukkit.getPluginManager().registerEvents(new ToggleFlight(),this);
        Bukkit.getPluginManager().registerEvents(new UnleashEntity(),this);
        Bukkit.getPluginManager().registerEvents(new BlockBreak(),this);
        Bukkit.getPluginManager().registerEvents(new BlockPlace(),this);
        Bukkit.getPluginManager().registerEvents(new EnchantItem(),this);
        Bukkit.getPluginManager().registerEvents(new PrepareItemEnchant(),this);
        Bukkit.getPluginManager().registerEvents(new SignChange(),this);
        getCommand("DisableInteraction").setExecutor(new DisableInteraction());
        getCommand("DisableInteraction").setTabCompleter(new DisableInteraction());
    }

    public static Main getPlugin(){
        return plugin;
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.GREEN+"插件已卸载 作者：北风_TheNorthFeng");
        this.saveDefaultConfig();
    }
}
