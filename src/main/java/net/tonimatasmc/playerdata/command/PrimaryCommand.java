package net.tonimatasmc.playerdata.command;

import net.tonimatasmc.playerdata.manager.MessageManager;
import net.tonimatasmc.playerdata.manager.YMLManager;
import net.tonimatasmc.playerdata.storage.PluginDescription;
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
                        YMLManager.reload();
                        player.sendMessage(PluginDescription.getPrefixPositive() + "The plugin has been reloaded");
                    } else {
                        MessageManager.sendNotPermission(player);
                    }
                }

                if (args[0].equalsIgnoreCase("version")) {
                    if (Objects.requireNonNull(player).hasPermission("playerdata.version")) {
                        YMLManager.reload();
                        player.sendMessage(PluginDescription.getPrefixPositive() + "The plugin version is " + PluginDescription.getVersion());
                    } else {
                        MessageManager.sendNotPermission(player);
                    }
                }
            } else {
                Objects.requireNonNull(sender).sendMessage(ChatColor.translateAlternateColorCodes('&', PluginDescription.getPrefixWarning() + "Syntax error"));
            }


        }return false;
    }
}
