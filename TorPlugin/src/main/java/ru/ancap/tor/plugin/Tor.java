package ru.ancap.tor.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import ru.ancap.tor.api.develop.config.TorConfig;

public final class Tor extends JavaPlugin {

    private static Plugin plugin;

    private ChatListener chatListener;

    public static Plugin loadedPlugin() {
        return Tor.plugin;
    }

    @Override
    public void onEnable() {
        this.setupConfig();
        this.registerListeners();
        this.loadPlugin();
    }

    private static Tor getInstance() {
        return (Tor) plugin;
    }

    private void loadPlugin() {
        plugin = this;
    }

    private void registerListeners() {
        this.chatListener = new ChatListener();
        Bukkit.getPluginManager().registerEvents(chatListener, this);
    }

    private void setupConfig() {
        this.saveDefaultConfig();
        new TorConfig(this.getConfig()).setup();
    }

    @Override
    public void onDisable() {
    }
}
