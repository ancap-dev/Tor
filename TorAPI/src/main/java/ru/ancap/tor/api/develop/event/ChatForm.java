package ru.ancap.tor.api.develop.event;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;
import org.bukkit.event.player.AsyncPlayerChatEvent;

@AllArgsConstructor
public class ChatForm implements EventForm {

    @Delegate
    private final AsyncPlayerChatEvent event;

}
