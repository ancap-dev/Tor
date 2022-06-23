package ru.ancap.tor.api.develop;

import ru.ancap.tor.api.develop.event.EventForm;

public interface IllegalChecker {

    boolean isIllegal(EventForm form);

}
