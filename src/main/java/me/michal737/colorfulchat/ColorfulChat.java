package me.michal737.colorfulchat;

import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.JavaPlugin;

public final class ColorfulChat extends JavaPlugin {

    @Override
    public void onEnable() {

        getServer().getPluginManager().addPermission(new Permission("colorfulchat.colors", "Allows players to send colorful chat messages.", PermissionDefault.TRUE));

        getServer().getPluginManager().registerEvents(new ChatMessageEvent(), this);

        getLogger().info("ColorfulChat enabled!");

    }

    @Override
    public void onDisable() {

        getLogger().info("ColorfulChat disabled!");

    }

}
