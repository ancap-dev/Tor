package ru.ancap.tor.api.develop.config;

import org.bukkit.configuration.Configuration;

public class TorConfig {

    private static TorConfig config;

    private final Configuration configuration;

    public TorConfig(Configuration configuration) {
        this.configuration = configuration;
    }

    public static TorConfig loaded() {
        return config;
    }

    public void setup() {
        config = this;
    }

    public boolean sendDebug() {
        return this.configuration.getBoolean("send_debug");
    }

    public String debugMessage() {
        return this.configuration.getString("debug_message");
    }

    public String debugHoverMessage() {
        return this.configuration.getString("debug_hover_message");
    }
}
