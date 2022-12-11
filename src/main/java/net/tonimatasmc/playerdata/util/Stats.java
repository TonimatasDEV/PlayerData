package net.tonimatasmc.playerdata.util;

import net.tonimatasmc.playerdata.recompense.YML.RecompensesYML;

import java.util.ArrayList;
import java.util.List;

public class Stats {
    private static final List<String> stats = new ArrayList<>();

    public static void register() {
        stats.add("BlocksBreakCount");
        stats.add("DeathCount");
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
