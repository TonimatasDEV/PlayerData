package net.tonimatasmc.playerdata.storage.YML;

import net.tonimatasmc.playerdata.PlayerData;

import java.io.File;

public class Config {
    public static void registerConfig() {
        File config = new File(PlayerData.getPlugin().getDataFolder(), "config.yml");

        if (!config.exists()) {
            PlayerData.getPlugin().getConfig().options().copyDefaults(true);
            PlayerData.getPlugin().saveConfig();
        }
    }
}
