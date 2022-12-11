package net.tonimatasmc.playerdata.recompense.actions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Sound {
    public static void execute(String sound, Player player) {
        String x = String.valueOf(player.getLocation().getBlockX());
        String y = String.valueOf(player.getLocation().getBlockY());
        String z = String.valueOf(player.getLocation().getBlockZ());

        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "playsound " + sound + " master " + player.getName() + " " + x + " " + y + " " + z + " ");
    }
}
