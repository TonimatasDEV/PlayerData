package net.tonimatasmc.playerdata.tabulatorCompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TabulatorCompleter implements TabCompleter {


    @Override
    public List<String> onTabComplete(@Nullable CommandSender sender, @Nullable Command command, @Nullable String label, @Nullable String[] args) {
        assert command != null;
        assert args != null;

        if (command.getName().equalsIgnoreCase("playerdata")) {
            List<String> argList = new ArrayList<>();

            if (args.length == 1) {
                argList.add("reload");
                argList.add("version");
                return argList.stream().filter(a -> a.startsWith(args[0])).collect(Collectors.toList());
            }return argList;
        }return null;
    }
}
