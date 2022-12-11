package net.tonimatasmc.playerdata.event;

import net.tonimatasmc.playerdata.recompense.Detector;
import net.tonimatasmc.playerdata.storage.Paths;
import net.tonimatasmc.playerdata.storage.YML.PerPlayerData;
import net.tonimatasmc.playerdata.util.SetAndGetConfigurations;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        int count = SetAndGetConfigurations.getConfigInt(PerPlayerData.getData(event.getEntity().getName()),"DeathCount");
        SetAndGetConfigurations.setConfig(PerPlayerData.getData(event.getEntity().getName()), "DeathCount", count + 1, Paths.getDataPath(event.getEntity().getName()));

        Detector.normal("DeathCount", event.getEntity());

    }
}
