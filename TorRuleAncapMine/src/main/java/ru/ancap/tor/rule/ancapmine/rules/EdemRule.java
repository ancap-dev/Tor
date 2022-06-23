package ru.ancap.tor.rule.ancapmine.rules;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import ru.ancap.tor.api.develop.template.ChatProtectRule;
import ru.ancap.tor.api.develop.event.EventForm;

public class EdemRule extends ChatProtectRule {

    public EdemRule() {
        super(
                "эдэм"
        );
    }

    @Override
    public void operate(EventForm form) {
        form.setCancelled(true);
        Player player = form.getPlayer();
        String message = form.getMessage();
        form.getPlayer().sendMessage("§cНе пиарь на Анкапе всякие параши.");
        String lowerCaseMessage = message.toLowerCase();
        if (lowerCaseMessage.contains("edemmine") && !(player.isOp())) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    Bukkit.dispatchCommand(
                            Bukkit.getConsoleSender(),
                            "ban "+form.getPlayer().getName()+" §cНе пиарь на Анкапе всякие параши. За разбаном обращайся к vk.com/vovanchikputin"
                    );
                }
            }.run();
        }
        if (lowerCaseMessage.contains("эдем")) {
            player.spigot().sendMessage(
                    new ComponentBuilder("Если хочешь узнать, что такое \"Эдем\", кликни по этому сообщению.")
                            .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://vk.com/@puk_pukov-istoriya-samogo-bolshogo-obmana-server-dlya-ikarusa"))
                            .color(ChatColor.RED)
                            .color(ChatColor.UNDERLINE)
                            .create()
            );
        }
    }
}
