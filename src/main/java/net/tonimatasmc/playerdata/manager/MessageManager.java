package net.tonimatasmc.playerdata.manager;

import net.tonimatasmc.playerdata.storage.PluginDescription;
import net.tonimatasmc.playerdata.storage.YML.Messages;
import net.tonimatasmc.playerdata.util.SetAndGetConfigurations;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MessageManager {
    public static void register() {
        Bukkit.getConsoleSender().sendMessage("- - - - - - - - - - - - - - - - - - - - - - - -");
        Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixPositive() + "The plugin has been enabled");
        Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixPositive() + "Version: " + PluginDescription.getVersion());
        Bukkit.getConsoleSender().sendMessage("- - - - - - - - - - - - - - - - - - - - - - - -");
    }

    public static void unregister() {
        Bukkit.getConsoleSender().sendMessage("- - - - - - - - - - - - - - - - - - - - - - - -");
        Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixNegative() + "The plugin has been disabled");
        Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixNegative() + "Version: " + PluginDescription.getVersion());
        Bukkit.getConsoleSender().sendMessage("- - - - - - - - - - - - - - - - - - - - - - - -");
    }

    public static void sendNotPermission(Player player) {
        player.sendMessage(PluginDescription.getPrefixNegative() + SetAndGetConfigurations.getConfigString(Messages.getMessages(), "WithoutPermission"));
    }
}
