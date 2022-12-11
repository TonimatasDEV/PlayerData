package net.tonimatasmc.playerdata.recompense;

import net.tonimatasmc.playerdata.recompense.YML.RecompensesYML;
import net.tonimatasmc.playerdata.recompense.actions.*;
import net.tonimatasmc.playerdata.util.SetAndGetConfigurations;
import org.bukkit.entity.Player;

import java.util.List;

public class Executor {
    public static void normal(List<String> actions, String stat, String data, Player player) {
        if (actions.contains("command")) {
            String command = SetAndGetConfigurations.getConfigString(RecompensesYML.getStatRecompensesYML(stat), "recompenses." + data + ".command");
            Command.execute(command.replace("/", ""), player);
        }

        if (actions.contains("sound")) {
            String sound = SetAndGetConfigurations.getConfigString(RecompensesYML.getStatRecompensesYML(stat), "recompenses." + data + ".sound");
            Sound.execute(sound, player);
        }

        if (actions.contains("message")) {
            List<String> message = SetAndGetConfigurations.getConfigStringList(RecompensesYML.getStatRecompensesYML(stat), "recompenses." + data + ".message");
            Message.execute(message, player);
        }

        if (actions.contains("broadcast")) {
            List<String> broadcast = SetAndGetConfigurations.getConfigStringList(RecompensesYML.getStatRecompensesYML(stat), "recompenses." + data + ".broadcast");
            BroadCast.execute(broadcast, player);
        }

        if (actions.contains("permission")) {
            String permission = SetAndGetConfigurations.getConfigString(RecompensesYML.getStatRecompensesYML(stat), "recompenses." + data + ".permission");
            Permission.execute(permission, player);
        }
    }
}
