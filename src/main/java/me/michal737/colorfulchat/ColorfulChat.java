package me.michal737.colorfulchat;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.JavaPlugin;

public final class ColorfulChat extends JavaPlugin {

    @Override
    public void onEnable() {

        getServer().getPluginManager().addPermission(new Permission("colorfulchat.chat", "Allows players to send colorful chat messages.", PermissionDefault.TRUE));
        getServer().getPluginManager().addPermission(new Permission("colorfulchat.chat-items", "Allows players to display their held items in chat.", PermissionDefault.TRUE));
        getServer().getPluginManager().addPermission(new Permission("colorfulchat.anvil", "Allows players to rename items with colors.", PermissionDefault.TRUE));

        loadConfig();

        getServer().getPluginManager().registerEvents(new Events(), this);

        getLogger().info("ColorfulChat enabled!");

    }

    @Override
    public void onDisable() {

        getLogger().info("ColorfulChat disabled!");

    }

    public static boolean enableChat, enableChatItems, enableAnvils;

    public void loadConfig() {

        //noinspection ResultOfMethodCallIgnored
        getDataFolder().mkdir();
        saveDefaultConfig();

        FileConfiguration config = getConfig();

        enableChat = config.getBoolean("enable-chat", true);
        enableChatItems = config.getBoolean("enable-chat-items", true);
        enableAnvils = config.getBoolean("enable-anvils", true);

    }

}
