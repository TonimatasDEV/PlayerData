package net.tonimatasdev.playerdata.recompense.actions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class Message {
    public static void execute(List<String> messages, Player player) {
        for (String s : messages) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', s.replace("%player%", player.getName())));
        }
    }
}
