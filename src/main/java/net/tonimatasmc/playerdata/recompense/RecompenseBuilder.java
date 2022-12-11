package net.tonimatasmc.playerdata.recompense;

import net.tonimatasmc.playerdata.recompense.util.BlockDetector;
import net.tonimatasmc.playerdata.util.Paths;
import net.tonimatasmc.playerdata.helper.YMLHelper;
import net.tonimatasmc.playerdata.util.YML.PerPlayerData;
import org.bukkit.entity.Player;

public class RecompenseBuilder {
    public static void addSimple(Player player, String stat) {
        int count = YMLHelper.getConfigInt(PerPlayerData.getData(player.getName()), stat);
        YMLHelper.setConfig(PerPlayerData.getData(player.getName()), stat, count + 1, Paths.getDataPath(player.getName()));

        BlockDetector.normal(stat, player);
    }
}
