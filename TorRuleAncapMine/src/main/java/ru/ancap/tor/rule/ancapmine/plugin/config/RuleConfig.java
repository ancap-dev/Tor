package ru.ancap.tor.rule.ancapmine.plugin.config;

import org.bukkit.configuration.Configuration;

public class RuleConfig {

    private static RuleConfig config;

    private final Configuration configuration;

    public RuleConfig(Configuration configuration) {
        this.configuration = configuration;
    }

    public static RuleConfig loaded() {
        return config;
    }

    public void setup() {
        config = this;
    }

    public String wipeDate() {
        return this.configuration.getString("wipe_was");
    }
}
