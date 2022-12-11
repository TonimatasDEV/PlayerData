package net.tonimatasmc.playerdata;

import net.tonimatasmc.playerdata.command.PrimaryCommand;
import net.tonimatasmc.playerdata.event.ServerJoinEvent;
import net.tonimatasmc.playerdata.event.StatEvent;
import net.tonimatasmc.playerdata.tabulatorCompleter.TabulatorCompleter;
import net.tonimatasmc.playerdata.util.Information;
import net.tonimatasmc.playerdata.util.Stats;
import net.tonimatasmc.playerdata.util.YML.Config;
import net.tonimatasmc.playerdata.util.YML.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class PlayerData extends JavaPlugin {
    public static PlayerData plugin;

    @Override
    public void onEnable() {
        Server server = PlayerData.getPlugin().getServer();
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

        server.getPluginManager().registerEvents(new ServerJoinEvent(), this);
        server.getPluginManager().registerEvents(new StatEvent(), this);

        server.getPluginCommand("playerdata").setExecutor(new PrimaryCommand());
        server.getPluginCommand("playerdata").setTabCompleter(new TabulatorCompleter());

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
