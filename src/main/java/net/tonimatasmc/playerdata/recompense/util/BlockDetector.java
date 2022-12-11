package net.tonimatasmc.playerdata.recompense.util;

import net.tonimatasmc.playerdata.recompense.Executor;
import net.tonimatasmc.playerdata.recompense.YML.RecompensesYML;
import net.tonimatasmc.playerdata.util.YML.PerPlayerData;
import net.tonimatasmc.playerdata.util.SetAndGetConfigurations;
import org.bukkit.entity.Player;

import java.util.List;

public class BlockDetector {
    public static void normal(String stat, Player player) {
        if (SetAndGetConfigurations.getConfigBoolean(RecompensesYML.getStatRecompensesYML(stat), "enabled")) {
            List<String> recompenses = SetAndGetConfigurations.getConfigStringList(RecompensesYML.getStatRecompensesYML(stat), "recompenses");
            String data = String.valueOf(SetAndGetConfigurations.getConfigInt(PerPlayerData.getData(player.getName()), stat));

            if (stat.equalsIgnoreCase("BlocksBreakCount")) {
                data = String.valueOf(SetAndGetConfigurations.getConfigInt(PerPlayerData.getData(player.getName()), stat + ".all"));
            }

            if (!recompenses.isEmpty()) {
                if (recompenses.contains(data)) {
                    List<String> actions = SetAndGetConfigurations.getConfigStringList(RecompensesYML.getStatRecompensesYML(stat), "recompenses." + data);

                    if (!actions.isEmpty()) {
                        Executor.normal(actions, stat, data, player);
                    }
                }
            }
        }
    }
}
