package net.tonimatasdev.playerdata.recompense.actions;

import org.bukkit.entity.Player;

public class Permission {
    public static void execute(String permission, Player player) {
        player.hasPermission(permission);
    }
}
