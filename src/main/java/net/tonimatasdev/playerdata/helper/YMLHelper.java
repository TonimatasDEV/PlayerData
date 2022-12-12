package net.tonimatasdev.playerdata.helper;

import org.bukkit.Color;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class YMLHelper {
    public static String getConfigString(FileConfiguration yml, String configSection) {
        return yml.getString(configSection);
    }

    public static int getConfigInt(FileConfiguration yml, String configSection) {
        return yml.getInt(configSection);
    }

    public static boolean getConfigBoolean(FileConfiguration yml, String configSection) {
        return yml.getBoolean(configSection);
    }

    public static ItemStack getConfigItemStack(FileConfiguration yml, String configSection) {
        return yml.getItemStack(configSection);
    }

    public static ConfigurationSection getConfigurationSection(FileConfiguration yml, String configSection) {
        return yml.getConfigurationSection(configSection);
    }

    public static Vector getConfigVector(FileConfiguration yml, String configSection) {
        return yml.getVector(configSection);
    }

    public static double getConfigDouble(FileConfiguration yml, String configSection) {
        return yml.getDouble(configSection);
    }

    @SuppressWarnings("rawtypes")
    public static List getConfigList(FileConfiguration yml, String configSection) {
        return yml.getList(configSection);
    }

    public static Object getConfig(FileConfiguration yml, String configSection) {
        return yml.get(configSection);
    }

    public static long getConfigLong(FileConfiguration yml, String configSection) {
        return yml.getLong(configSection);
    }

    public static Color getConfigColor(FileConfiguration yml, String configSection) {
        return yml.getColor(configSection);
    }

    public static List<Float> getConfigFloatList(FileConfiguration yml, String configSection) {
        return yml.getFloatList(configSection);
    }

    public static List<Boolean> getConfigBooleanList(FileConfiguration yml, String configSection) {
        return yml.getBooleanList(configSection);
    }

    public static List<Map<?, ?>> getConfigMapList(FileConfiguration yml, String configSection) {
        return yml.getMapList(configSection);
    }

    public static List<Integer> getConfigIntegerList(FileConfiguration yml, String configSection) {
        return yml.getIntegerList(configSection);
    }

    public static List<String> getConfigInlineComments(FileConfiguration yml, String configSection) {
        return yml.getInlineComments(configSection);
    }

    public static List<String> getConfigComments(FileConfiguration yml, String configSection) {
        return yml.getComments(configSection);
    }

    public static List<String> getConfigStringList(FileConfiguration yml, String configSection) {
        return yml.getStringList(configSection);
    }

    public static List<Long> getConfigLongList(FileConfiguration yml, String configSection) {
        return yml.getLongList(configSection);
    }

//----------------------------------------------------------------------------------------------------------------------

    public static void setConfig(FileConfiguration yml, String configSection, Object value, File file) {
        yml.set(configSection, value);
        yml.isSet(configSection);

        try {
            yml.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setConfigInlineComments(FileConfiguration yml, String configSection, List<String> value) {
        yml.setInlineComments(configSection, value);
    }

    public static void setConfigComments(FileConfiguration yml, String configSection, List<String> value) {
        yml.setComments(configSection, value);
    }

    public static void setConfigDefaults(FileConfiguration yml, Configuration defaults) {
        yml.setDefaults(defaults);
    }

//----------------------------------------------------------------------------------------------------------------------

    public static boolean isExist(FileConfiguration yml, String configSection) {
        return yml.getConfigurationSection(configSection) != null;
    }
}
