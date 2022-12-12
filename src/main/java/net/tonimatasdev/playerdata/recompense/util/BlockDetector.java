package net.tonimatasdev.playerdata.recompense.util;

import net.tonimatasdev.playerdata.helper.YMLHelper;
import net.tonimatasdev.playerdata.recompense.YML.RecompensesYML;
import net.tonimatasdev.playerdata.util.YML.PerPlayerData;
import net.tonimatasdev.playerdata.recompense.Executor;
import org.bukkit.entity.Player;

import java.util.List;

public class BlockDetector {
    public static void normal(String stat, Player player) {
        if (YMLHelper.getConfigBoolean(RecompensesYML.getStatRecompensesYML(stat), "enabled")) {
            List<String> recompenses = YMLHelper.getConfigStringList(RecompensesYML.getStatRecompensesYML(stat), "recompenses");
            String data = String.valueOf(YMLHelper.getConfigInt(PerPlayerData.getData(player.getName()), stat));

            if (stat.equalsIgnoreCase("BlocksBreakCount")) {
                data = String.valueOf(YMLHelper.getConfigInt(PerPlayerData.getData(player.getName()), stat + ".all"));
            }

            if (!recompenses.isEmpty()) {
                if (recompenses.contains(data)) {
                    List<String> actions = YMLHelper.getConfigStringList(RecompensesYML.getStatRecompensesYML(stat), "recompenses." + data);

                    if (!actions.isEmpty()) {
                        Executor.normal(actions, stat, data, player);
                    }
                }
            }
        }
    }
}
