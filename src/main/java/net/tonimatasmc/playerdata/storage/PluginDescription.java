package net.tonimatasmc.playerdata.storage;

import net.tonimatasmc.playerdata.PlayerData;
import org.bukkit.ChatColor;

public class PluginDescription {
    private static String prefixPositive;
    private static String prefixNegative;
    private static String prefixWarning;
    private static String description;
    private static String version;
    private static String name;

    public static void register() {
        version = PlayerData.getPlugin().getDescription().getVersion();
        description = PlayerData.getPlugin().getDescription().getDescription();
        name = PlayerData.getPlugin().getDescription().getName();
        prefixPositive = ChatColor.translateAlternateColorCodes('&', "&f[&a+&f] &f&l" + PluginDescription.getName() + ": &7");
        prefixNegative = ChatColor.translateAlternateColorCodes('&', "&f[&c-&f] &f&l" + PluginDescription.getName() + ": &7");
        prefixWarning = ChatColor.translateAlternateColorCodes('&', "&f[&e=&f] &f&l" + PluginDescription.getName() + ": &7");
    }

    public static String getVersion() {
        return version;
    }

    public static String getDescription() {
        return description;
    }

    public static String getName() {
        return name;
    }

    public static String getPrefixPositive() {
        return prefixPositive;
    }

    public static String getPrefixNegative() {
        return prefixNegative;
    }

    public static String getPrefixWarning() {
        return prefixWarning;
    }
}
