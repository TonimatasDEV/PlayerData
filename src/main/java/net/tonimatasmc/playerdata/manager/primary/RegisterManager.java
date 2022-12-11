package net.tonimatasmc.playerdata.manager.primary;

import net.tonimatasmc.playerdata.PlayerData;
import net.tonimatasmc.playerdata.command.PrimaryCommand;
import net.tonimatasmc.playerdata.event.BlockBreakEvent;
import net.tonimatasmc.playerdata.event.DeathEvent;
import net.tonimatasmc.playerdata.event.ServerJoinEvent;
import net.tonimatasmc.playerdata.manager.MessageManager;
import net.tonimatasmc.playerdata.manager.YMLManager;
import net.tonimatasmc.playerdata.storage.PluginDescription;
import net.tonimatasmc.playerdata.tabulatorCompleter.TabulatorCompleter;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.io.File;
import java.util.Objects;

public class RegisterManager {
    public static void register() {
        registerFolders();
        PluginDescription.register();
        YMLManager.register();
        MessageManager.register();

        registerEvents(PlayerData.getPlugin().getServer().getPluginManager(), PlayerData.getPlugin());
        registerCommands(PlayerData.getPlugin().getServer());
        registerTabulatorCompleter(PlayerData.getPlugin().getServer());
    }

    private static void registerCommands(Server server) {
        Objects.requireNonNull(server.getPluginCommand("playerdata")).setExecutor(new PrimaryCommand());
    }

    private static void registerTabulatorCompleter(Server server) {
        Objects.requireNonNull(server.getPluginCommand("playerdata")).setTabCompleter(new TabulatorCompleter());
    }

    private static void registerEvents(PluginManager pluginManager, Plugin plugin) {
        pluginManager.registerEvents(new ServerJoinEvent(), plugin);
        pluginManager.registerEvents(new BlockBreakEvent(), plugin);
        pluginManager.registerEvents(new DeathEvent(), plugin);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static void registerFolders() {
        File data = new File(PlayerData.getPlugin().getDataFolder() + "\\data");

        if (!data.exists()){
            data.mkdirs();
        }

        File recompenses = new File(PlayerData.getPlugin().getDataFolder() + "\\recompenses");

        if (!recompenses.exists()){
            recompenses.mkdirs();
        }
    }
}
