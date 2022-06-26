package ru.ancap.tor.rule.ancapmine.rules;

import ru.ancap.tor.api.develop.template.ChatProtectRule;
import ru.ancap.tor.api.develop.event.EventForm;
import ru.ancap.tor.rule.ancapmine.plugin.config.RuleConfig;

public class WipeRule extends ChatProtectRule {

    public WipeRule() {
        super(
                "ваип",
                "випе",
                "новыисезон",
                "веип"
        );
    }

    @Override
    public void operate(EventForm form) {
        form.setCancelled(true);
        form.getPlayer().sendMessage("§cВайп был §6" + RuleConfig.loaded().wipeDate() +"§c. Пожалуйста, не распространяй лишние слухи о вайпе.");
    }
}
