package net.tonimatasmc.playerdata.recompense.YML;

import net.tonimatasmc.playerdata.PlayerData;
import net.tonimatasmc.playerdata.util.Paths;
import net.tonimatasmc.playerdata.helper.YMLHelper;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class RecompensesYML {
    private static FileConfiguration statRecompensesYML = null;

    public static FileConfiguration getStatRecompensesYML(String recompensesYML) {
        if (statRecompensesYML == null) {
            reloadStatRecompensesYML(recompensesYML);
        }

        return statRecompensesYML;
    }

    public static void reloadStatRecompensesYML(String recompensesYML) {
        if (statRecompensesYML == null) {
            new File(PlayerData.getPlugin().getDataFolder() + "\\recompenses", recompensesYML + ".yml");
        }

        statRecompensesYML = YamlConfiguration.loadConfiguration(new File(PlayerData.getPlugin().getDataFolder() + "\\recompenses", recompensesYML + ".yml"));
    }

    public static void saveStatRecompensesYML(String recompensesYML) {
        try {
            statRecompensesYML.save(new File(PlayerData.getPlugin().getDataFolder() + "\\recompenses", recompensesYML + ".yml"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public static void registerStatRecompensesYML(String recompensesYML) {
        if (!(new File(PlayerData.getPlugin().getDataFolder() + "\\recompenses", recompensesYML + ".yml")).exists()) {
            YMLHelper.setConfig(RecompensesYML.getStatRecompensesYML(recompensesYML),"enabled" , true, Paths.getRecompensesPath(recompensesYML));
            YMLHelper.setConfig(RecompensesYML.getStatRecompensesYML(recompensesYML),"recompenses.1000.command" , "give %player% minecraft:diamond_sword", Paths.getRecompensesPath(recompensesYML));
            YMLHelper.setConfig(RecompensesYML.getStatRecompensesYML(recompensesYML),"recompenses.1000.sound" , "entity.firework_rocket.large_blast", Paths.getRecompensesPath(recompensesYML));
            YMLHelper.setConfig(RecompensesYML.getStatRecompensesYML(recompensesYML),"recompenses.1000.permission" , "example", Paths.getRecompensesPath(recompensesYML));
            YMLHelper.setConfig(RecompensesYML.getStatRecompensesYML(recompensesYML),"recompenses.1000.command" , "give %player% minecraft:diamond_sword", Paths.getRecompensesPath(recompensesYML));
            YMLHelper.setConfig(RecompensesYML.getStatRecompensesYML(recompensesYML),"recompenses.1000.command" , "give %player% minecraft:diamond_sword", Paths.getRecompensesPath(recompensesYML));
            saveStatRecompensesYML(recompensesYML);
        }
    }
}
