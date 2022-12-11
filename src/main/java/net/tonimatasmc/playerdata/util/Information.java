package net.tonimatasmc.playerdata.util;

import net.tonimatasmc.playerdata.PlayerData;
import org.bukkit.ChatColor;

public class Information {
    private static String prefixPositive;
    private static String prefixNegative;
    private static String prefixWarning;
    private static String version;
    private static String name;

    public static void register() {
        version = PlayerData.getPlugin().getDescription().getVersion();
        name = PlayerData.getPlugin().getDescription().getName();
        prefixPositive = ChatColor.translateAlternateColorCodes('&', "&f[&a+&f] &f&l" + Information.getName() + ": &7");
        prefixNegative = ChatColor.translateAlternateColorCodes('&', "&f[&c-&f] &f&l" + Information.getName() + ": &7");
        prefixWarning = ChatColor.translateAlternateColorCodes('&', "&f[&e=&f] &f&l" + Information.getName() + ": &7");
    }

    public static String getVersion() {
        return version;
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
