package net.tonimatasdev.playerdata.recompense;

import net.tonimatasdev.playerdata.util.YML.PerPlayerData;
import net.tonimatasdev.playerdata.recompense.util.BlockDetector;
import net.tonimatasdev.playerdata.util.Paths;
import net.tonimatasdev.playerdata.helper.YMLHelper;
import org.bukkit.entity.Player;

public class RecompenseBuilder {
    public static void addSimple(Player player, String stat) {
        int count = YMLHelper.getConfigInt(PerPlayerData.getData(player.getName()), stat);
        YMLHelper.setConfig(PerPlayerData.getData(player.getName()), stat, count + 1, Paths.getDataPath(player.getName()));

        BlockDetector.normal(stat, player);
    }
}
