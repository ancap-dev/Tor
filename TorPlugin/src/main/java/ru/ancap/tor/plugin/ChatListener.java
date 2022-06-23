package ru.ancap.tor.plugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import ru.ancap.tor.api.connect.TorAPI;
import ru.ancap.tor.api.develop.ChatProtector;
import ru.ancap.tor.api.develop.event.ChatForm;
import ru.ancap.tor.api.develop.event.CommandForm;
import ru.ancap.tor.api.develop.event.EventForm;

public class ChatListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void on(AsyncPlayerChatEvent event) {
        this.operate(new ChatForm(event));
    }

    @EventHandler
    public void on(PlayerCommandPreprocessEvent event) {
        this.operate(new CommandForm(event));
    }

    private void operate(EventForm form) {
        for (ChatProtector protector : TorAPI.loadedRules()) {
            if (protector.isIllegal(form)) {
                protector.operateIllegal(form);
            }
        }
    }

}
