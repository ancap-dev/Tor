package ru.ancap.tor.rule.ancapmine.plugin;

import com.sun.tools.javac.util.List;
import org.bukkit.plugin.java.JavaPlugin;
import ru.ancap.tor.api.connect.TorAPI;
import ru.ancap.tor.api.develop.ChatProtector;
import ru.ancap.tor.rule.ancapmine.plugin.config.RuleConfig;
import ru.ancap.tor.rule.ancapmine.rules.EdemRule;
import ru.ancap.tor.rule.ancapmine.rules.WipeRule;

public final class Rule extends JavaPlugin {

    private final List<ChatProtector> rules = List.of(
            new EdemRule(),
            new WipeRule()
    );

    @Override
    public void onEnable() {
        this.loadConfig();
        this.loadRules();
    }

    private void loadConfig() {
        new RuleConfig(this.getConfig()).setup();
    }

    private void loadRules() {
        for (ChatProtector protector : rules) {
            TorAPI.loadRule(protector);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
