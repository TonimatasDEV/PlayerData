package net.tonimatasmc.playerdata.command;

import net.tonimatasmc.playerdata.PlayerData;
import net.tonimatasmc.playerdata.helper.YMLHelper;
import net.tonimatasmc.playerdata.util.Information;
import net.tonimatasmc.playerdata.util.Stats;
import net.tonimatasmc.playerdata.util.YML.Messages;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.Objects;

public class PrimaryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@Nullable CommandSender sender, @Nullable Command command, @Nullable String label, @Nullable String[] args) {
        if (Objects.requireNonNull(command).getName().equalsIgnoreCase("playerdata")) {
            Player player = (Player) sender;
            assert args != null;

            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (Objects.requireNonNull(player).hasPermission("playerdata.reload")) {
                        PlayerData.getPlugin().reloadConfig();
                        PlayerData.getPlugin().saveConfig();

                        Messages.reloadMessages();
                        Messages.saveMessages();

                        Stats.YML(true);

                        player.sendMessage(Information.getPrefixPositive() + "The plugin has been reloaded");
                    } else {
                        player.sendMessage(Information.getPrefixNegative() + YMLHelper.getConfigString(Messages.getMessages(), "WithoutPermission"));
                    }
                }

                if (args[0].equalsIgnoreCase("version")) {
                    if (Objects.requireNonNull(player).hasPermission("playerdata.version")) {
                        player.sendMessage(Information.getPrefixPositive() + "The plugin version is " + Information.getVersion());
                    } else {
                        player.sendMessage(Information.getPrefixNegative() + YMLHelper.getConfigString(Messages.getMessages(), "WithoutPermission"));
                    }
                }
            } else {
                Objects.requireNonNull(sender).sendMessage(ChatColor.translateAlternateColorCodes('&', Information.getPrefixWarning() + "Syntax error"));
            }


        }return false;
    }
}
