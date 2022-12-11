package net.tonimatasmc.playerdata.storage.YML;

import net.tonimatasmc.playerdata.PlayerData;
import net.tonimatasmc.playerdata.storage.Paths;
import net.tonimatasmc.playerdata.util.SetAndGetConfigurations;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PerPlayerData {
    private static FileConfiguration data = null;

    public static FileConfiguration getData(String playerName) {
        if (data == null) {
            reloadData(playerName);
        }

        return data;
    }

    public static void reloadData(String playerName) {
        if (data == null) {
            new File(PlayerData.getPlugin().getDataFolder() + "\\data", playerName + ".yml");
        }

        data = YamlConfiguration.loadConfiguration(new File(PlayerData.getPlugin().getDataFolder() + "\\data", playerName + ".yml"));
    }

    public static void saveData(String playerName) {
        try {
            data.save(new File(PlayerData.getPlugin().getDataFolder() + "\\data", playerName + ".yml"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public static void registerData(String playerName) {
        if (!(new File(PlayerData.getPlugin().getDataFolder() + "\\data", playerName + ".yml")).exists()) {
            SetAndGetConfigurations.setConfig(PerPlayerData.getData(playerName), "BlocksBreakCount.all", 0, Paths.getDataPath(playerName));
            SetAndGetConfigurations.setConfig(PerPlayerData.getData(playerName), "DeathCount", 0, Paths.getDataPath(playerName));
            saveData(playerName);
        }
    }
}
