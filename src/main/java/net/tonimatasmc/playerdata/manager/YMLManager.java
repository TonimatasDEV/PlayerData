package net.tonimatasmc.playerdata.manager;

import net.tonimatasmc.playerdata.PlayerData;
import net.tonimatasmc.playerdata.recompense.YML.RecompensesYML;
import net.tonimatasmc.playerdata.storage.YML.Config;

public class YMLManager {
    public static void register() {
        Config.registerConfig();

        RecompensesYML.registerStatRecompensesYML("BlocksBreakCount");
        RecompensesYML.registerStatRecompensesYML("DeathCount");
    }

    public static void unregister() {
        PlayerData.getPlugin().saveConfig();

        RecompensesYML.reloadStatRecompensesYML("BlocksBreakCount");
        RecompensesYML.saveStatRecompensesYML("BlocksBreakCount");

        RecompensesYML.reloadStatRecompensesYML("DeathCount");
        RecompensesYML.saveStatRecompensesYML("DeathCount");
    }

    public static void reload() {
        PlayerData.getPlugin().reloadConfig();
        PlayerData.getPlugin().saveConfig();

        //Messages.reloadMessages();
        //Messages.saveMessages();

        RecompensesYML.reloadStatRecompensesYML("BlocksBreakCount");
        RecompensesYML.saveStatRecompensesYML("BlocksBreakCount");

        RecompensesYML.reloadStatRecompensesYML("DeathCount");
        RecompensesYML.saveStatRecompensesYML("DeathCount");
    }
}
