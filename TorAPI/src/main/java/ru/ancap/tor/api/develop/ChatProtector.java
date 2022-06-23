package ru.ancap.tor.api.develop;

import ru.ancap.tor.api.develop.event.EventForm;

public interface ChatProtector extends IllegalChecker {

    void operateIllegal(EventForm form);
}
