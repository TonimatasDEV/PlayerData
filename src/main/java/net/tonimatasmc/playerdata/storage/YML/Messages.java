package net.tonimatasmc.playerdata.storage.YML;

import net.tonimatasmc.playerdata.PlayerData;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Messages {
    private static FileConfiguration messages = null;
    private static File messagesFile = null;

    public static FileConfiguration getMessages() {
        if (messages == null) {
            reloadMessages();
        }return messages;
    }

    public static void reloadMessages() {
        if (messages == null) {
            messagesFile = new File(PlayerData.getPlugin().getDataFolder(), "messages.yml");
        }

        messages = YamlConfiguration.loadConfiguration(messagesFile);
        Reader defConfigStream = new InputStreamReader(Objects.requireNonNull(PlayerData.getPlugin().getResource("messages.yml")), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        messages.setDefaults(defConfig);
    }

    public static void saveMessages() {
        try {
            messages.save(messagesFile);
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public static void registerMessages() {
        messagesFile = new File(PlayerData.getPlugin().getDataFolder(), "messages.yml");

        if (!messagesFile.exists()) {
            getMessages().options().copyDefaults(true);
            saveMessages();
        }
    }
}
