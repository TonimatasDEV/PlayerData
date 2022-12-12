package net.tonimatasdev.playerdata.recompense;

import net.tonimatasdev.playerdata.helper.YMLHelper;
import net.tonimatasdev.playerdata.recompense.YML.RecompensesYML;
import net.tonimatasdev.playerdata.recompense.actions.*;
import net.tonimatasmc.playerdata.recompense.actions.*;
import org.bukkit.entity.Player;

import java.util.List;

public class Executor {
    public static void normal(List<String> actions, String stat, String data, Player player) {
        if (actions.contains("command")) {
            String command = YMLHelper.getConfigString(RecompensesYML.getStatRecompensesYML(stat), "recompenses." + data + ".command");
            Command.execute(command.replace("/", ""), player);
        }

        if (actions.contains("sound")) {
            String sound = YMLHelper.getConfigString(RecompensesYML.getStatRecompensesYML(stat), "recompenses." + data + ".sound");
            Sound.execute(sound, player);
        }

        if (actions.contains("message")) {
            List<String> message = YMLHelper.getConfigStringList(RecompensesYML.getStatRecompensesYML(stat), "recompenses." + data + ".message");
            Message.execute(message, player);
        }

        if (actions.contains("broadcast")) {
            List<String> broadcast = YMLHelper.getConfigStringList(RecompensesYML.getStatRecompensesYML(stat), "recompenses." + data + ".broadcast");
            BroadCast.execute(broadcast, player);
        }

        if (actions.contains("permission")) {
            String permission = YMLHelper.getConfigString(RecompensesYML.getStatRecompensesYML(stat), "recompenses." + data + ".permission");
            Permission.execute(permission, player);
        }
    }
}
