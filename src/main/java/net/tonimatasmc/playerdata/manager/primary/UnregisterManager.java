package net.tonimatasmc.playerdata.manager.primary;

import net.tonimatasmc.playerdata.manager.MessageManager;
import net.tonimatasmc.playerdata.manager.YMLManager;

public class UnregisterManager {
    public static void unregister() {
        YMLManager.unregister();
        MessageManager.unregister();
    }
}
