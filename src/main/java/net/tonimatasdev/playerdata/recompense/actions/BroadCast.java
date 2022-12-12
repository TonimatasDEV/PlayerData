package net.tonimatasdev.playerdata.recompense.actions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class BroadCast {
    public static void execute(List<String> messages, Player player) {
        for (String s : messages) {
            Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', s.replace("%player%", player.getName())));
        }
    }
}
