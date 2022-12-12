package net.tonimatasdev.playerdata;

import net.tonimatasdev.playerdata.command.PrimaryCommand;
import net.tonimatasdev.playerdata.event.ServerJoinEvent;
import net.tonimatasdev.playerdata.event.StatEvent;
import net.tonimatasdev.playerdata.tabulatorCompleter.TabulatorCompleter;
import net.tonimatasdev.playerdata.util.Information;
import net.tonimatasdev.playerdata.util.Stats;
import net.tonimatasdev.playerdata.util.YML.Config;
import net.tonimatasdev.playerdata.util.YML.Messages;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class PlayerData extends JavaPlugin {
    public static PlayerData plugin;

    @Override
    public void onEnable() {
        plugin = this;

        File data = new File(PlayerData.getPlugin().getDataFolder() + "\\data");
        if (!data.exists()) data.mkdirs();

        File recompenses = new File(PlayerData.getPlugin().getDataFolder() + "\\recompenses");
        if (!recompenses.exists()) recompenses.mkdirs();

        Information.register();
        Stats.register();

        Config.registerConfig();
        Messages.registerMessages();
        Stats.YML(false);

        PlayerData.getPlugin().getServer().getPluginManager().registerEvents(new ServerJoinEvent(), this);
        PlayerData.getPlugin().getServer().getPluginManager().registerEvents(new StatEvent(), this);

        PlayerData.getPlugin().getServer().getPluginCommand("playerdata").setExecutor(new PrimaryCommand());
        PlayerData.getPlugin().getServer().getPluginCommand("playerdata").setTabCompleter(new TabulatorCompleter());

        Bukkit.getConsoleSender().sendMessage("- - - - - - - - - - - - - - - - - - - - - - - -");
        Bukkit.getConsoleSender().sendMessage(Information.getPrefixPositive() + "The plugin has been enabled");
        Bukkit.getConsoleSender().sendMessage(Information.getPrefixPositive() + "Version: " + Information.getVersion());
        Bukkit.getConsoleSender().sendMessage("- - - - - - - - - - - - - - - - - - - - - - - -");
    }

    @Override
    public void onDisable() {
        PlayerData.getPlugin().saveConfig();
        Messages.saveMessages();
        Stats.YML(true);

        Bukkit.getConsoleSender().sendMessage("- - - - - - - - - - - - - - - - - - - - - - - -");
        Bukkit.getConsoleSender().sendMessage(Information.getPrefixNegative() + "The plugin has been disabled");
        Bukkit.getConsoleSender().sendMessage(Information.getPrefixNegative() + "Version: " + Information.getVersion());
        Bukkit.getConsoleSender().sendMessage("- - - - - - - - - - - - - - - - - - - - - - - -");
    }

    public static PlayerData getPlugin() {
        return plugin;
    }
}
