package ru.ancap.tor.api.develop.event;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

@AllArgsConstructor
public class CommandForm implements EventForm {

    @Delegate
    private final PlayerCommandPreprocessEvent event;

}
