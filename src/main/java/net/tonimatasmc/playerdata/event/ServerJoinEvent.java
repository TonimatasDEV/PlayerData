package net.tonimatasmc.playerdata.event;

import net.tonimatasmc.playerdata.storage.YML.PerPlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ServerJoinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PerPlayerData.registerData(player.getName());
    }
}
