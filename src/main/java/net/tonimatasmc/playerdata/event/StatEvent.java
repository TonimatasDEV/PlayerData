package net.tonimatasmc.playerdata.event;

import net.tonimatasmc.playerdata.recompense.util.BlockDetector;
import net.tonimatasmc.playerdata.recompense.RecompenseBuilder;
import net.tonimatasmc.playerdata.util.Paths;
import net.tonimatasmc.playerdata.util.SetAndGetConfigurations;
import net.tonimatasmc.playerdata.util.YML.PerPlayerData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class StatEvent implements Listener {
    @EventHandler
    public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent event) {
        int count = SetAndGetConfigurations.getConfigInt(PerPlayerData.getData(event.getPlayer().getName()),"BlocksBreakCount.all");
        SetAndGetConfigurations.setConfig(PerPlayerData.getData(event.getPlayer().getName()), "BlocksBreakCount.all", count + 1, Paths.getDataPath(event.getPlayer().getName()));

        if (SetAndGetConfigurations.getConfigInt(PerPlayerData.getData(event.getPlayer().getName()), "BlocksBreakCount." + event.getBlock().getType()) >= 1) {
            int countPerType = SetAndGetConfigurations.getConfigInt(PerPlayerData.getData(event.getPlayer().getName()),"BlocksBreakCount." + event.getBlock().getType());
            SetAndGetConfigurations.setConfig(PerPlayerData.getData(event.getPlayer().getName()), "BlocksBreakCount." + event.getBlock().getType(), 1 + countPerType, Paths.getDataPath(event.getPlayer().getName()));
        } else {
            SetAndGetConfigurations.setConfig(PerPlayerData.getData(event.getPlayer().getName()), "BlocksBreakCount." + event.getBlock().getType(), 1, Paths.getDataPath(event.getPlayer().getName()));
        }

        BlockDetector.normal("BlocksBreakCount", event.getPlayer());
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        RecompenseBuilder.add(event.getEntity(), "DeathCount");
    }
}
