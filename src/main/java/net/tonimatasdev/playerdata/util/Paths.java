package net.tonimatasdev.playerdata.util;

import net.tonimatasdev.playerdata.PlayerData;

import java.io.File;

public class Paths {
    public static File getDataPath(String playerName) {
        return new File(PlayerData.getPlugin().getDataFolder() + "\\data\\" + playerName + ".yml");
    }

    public static File getRecompensesPath(String stat) {
        return new File(PlayerData.getPlugin().getDataFolder() + "\\recompenses\\" + stat + ".yml");
    }
}
