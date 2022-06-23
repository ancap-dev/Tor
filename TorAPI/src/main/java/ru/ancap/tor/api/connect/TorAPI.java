package ru.ancap.tor.api.connect;

import ru.ancap.tor.api.develop.ChatProtector;

import java.util.ArrayList;
import java.util.List;

public class TorAPI {

    private static final List<ChatProtector> ruleList = new ArrayList<>();

    public static void loadRule(ChatProtector protector) {
        ruleList.add(protector);
    }

    public static List<ChatProtector> loadedRules() {
        return ruleList;
    }

}
