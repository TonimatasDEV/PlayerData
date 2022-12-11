package net.tonimatasmc.playerdata.recompense.actions;

import org.bukkit.entity.Player;

public class Sound {
    public static void execute(String sound, Player player) {
        player.playSound(player.getLocation(), sound, 10f, 10f);
    }
}
