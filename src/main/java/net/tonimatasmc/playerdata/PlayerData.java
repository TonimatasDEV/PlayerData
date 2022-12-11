package net.tonimatasmc.playerdata;

import net.tonimatasmc.playerdata.manager.primary.RegisterManager;
import net.tonimatasmc.playerdata.manager.primary.UnregisterManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerData extends JavaPlugin {
    public static PlayerData plugin;

    @Override
    public void onEnable() {
        plugin = this;
        RegisterManager.register();
    }

    @Override
    public void onDisable() {
        UnregisterManager.unregister();
    }

    public static PlayerData getPlugin() {
        return plugin;
    }
}
