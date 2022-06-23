package ru.ancap.tor.api.develop.event;

import org.bukkit.entity.Player;

public interface EventForm {

    Player getPlayer();
    String getMessage();
    void setCancelled(boolean cancel);
    void setMessage(String message);

}
