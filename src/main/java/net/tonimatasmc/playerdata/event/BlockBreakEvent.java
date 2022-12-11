package net.tonimatasmc.playerdata.event;

import net.tonimatasmc.playerdata.recompense.Detector;
import net.tonimatasmc.playerdata.storage.Paths;
import net.tonimatasmc.playerdata.storage.YML.PerPlayerData;
import net.tonimatasmc.playerdata.util.SetAndGetConfigurations;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockBreakEvent implements Listener {
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

        Detector.normal("BlocksBreakCount", event.getPlayer());
    }
}
