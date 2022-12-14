package net.tonimatasdev.playerdata.util;

import net.tonimatasdev.playerdata.recompense.YML.RecompensesYML;

import java.util.ArrayList;
import java.util.List;

public class Stats {
    private static final List<String> stats = new ArrayList<>();

    public static void register() {
        stats.add("BlocksBreakCount");
        stats.add("DeathCount");
        stats.add("ServerJoinCount");
        stats.add("ServerQuitCount");
    }

    public static List<String> getStats() {
        return stats;
    }

    public static void YML(boolean reload) {
        for (String stat : getStats()) {
            if (reload) {
                RecompensesYML.reloadStatRecompensesYML(stat);
                RecompensesYML.saveStatRecompensesYML(stat);
            } else {
                RecompensesYML.registerStatRecompensesYML(stat);
            }
        }
    }
}
