package net.tonimatasdev.playerdata.recompense.actions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command {
    public static void execute(String command, Player player) {
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), command.replaceAll("%player%", player.getName()));
    }
}
