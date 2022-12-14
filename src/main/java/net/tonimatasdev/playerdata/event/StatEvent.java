package net.tonimatasdev.playerdata.event;

import net.tonimatasdev.playerdata.helper.YMLHelper;
import net.tonimatasdev.playerdata.recompense.RecompenseBuilder;
import net.tonimatasdev.playerdata.util.Paths;
import net.tonimatasdev.playerdata.util.YML.PerPlayerData;
import net.tonimatasdev.playerdata.recompense.util.BlockDetector;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class StatEvent implements Listener {
    @EventHandler
    public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent event) {
        int count = YMLHelper.getConfigInt(PerPlayerData.getData(event.getPlayer().getName()),"BlocksBreakCount.all");
        YMLHelper.setConfig(PerPlayerData.getData(event.getPlayer().getName()), "BlocksBreakCount.all", count + 1, Paths.getDataPath(event.getPlayer().getName()));

        if (YMLHelper.getConfigInt(PerPlayerData.getData(event.getPlayer().getName()), "BlocksBreakCount." + event.getBlock().getType()) >= 1) {
            int countPerType = YMLHelper.getConfigInt(PerPlayerData.getData(event.getPlayer().getName()),"BlocksBreakCount." + event.getBlock().getType());
            YMLHelper.setConfig(PerPlayerData.getData(event.getPlayer().getName()), "BlocksBreakCount." + event.getBlock().getType(), 1 + countPerType, Paths.getDataPath(event.getPlayer().getName()));
        } else {
            YMLHelper.setConfig(PerPlayerData.getData(event.getPlayer().getName()), "BlocksBreakCount." + event.getBlock().getType(), 1, Paths.getDataPath(event.getPlayer().getName()));
        }

        BlockDetector.normal("BlocksBreakCount", event.getPlayer());
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        RecompenseBuilder.addSimple(event.getEntity(), "DeathCount");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        RecompenseBuilder.addSimple(event.getPlayer(), "ServerJoinCount");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        RecompenseBuilder.addSimple(event.getPlayer(), "ServerQuitCount");
    }
}
