package ru.ancap.tor.api.develop.template;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import ru.ancap.tor.api.develop.ChatProtector;
import ru.ancap.tor.api.develop.PotentialProvider;
import ru.ancap.tor.api.develop.SameSymbolsAbsoluter;
import ru.ancap.tor.api.develop.config.TorConfig;
import ru.ancap.tor.api.develop.event.EventForm;

import java.util.ArrayList;
import java.util.List;

public abstract class ChatProtectRule implements ChatProtector {

    private final static String garbage = " .,!?+-_:;";

    private final List<String> illegalWords;

    private final PotentialProvider potentialProvider;

    private String triggered;

    protected ChatProtectRule(List<String> illegalWords) {
        this.illegalWords = illegalWords;
        this.potentialProvider = new SameSymbolsAbsoluter();
    }

    protected ChatProtectRule(String... illegalWords) {
        this(List.of(illegalWords));
    }

    @Override
    public boolean isIllegal(EventForm form) {
        String message = form.getMessage();
        String prepared = this.prepare(message);
        List<String> absoluteCandidates = potentialProvider.potentialFor(prepared);
        for (String illegalWord : illegalWords) {
            for (String absoluteCandidate : absoluteCandidates) {
                if (absoluteCandidate.contains(illegalWord)) {
                    this.triggered = absoluteCandidate;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public final void operateIllegal(EventForm form) {
        form.setCancelled(true);
        this.operate(form);
        if (TorConfig.loaded().sendDebug()) {
            BaseComponent[] component = new ComponentBuilder(TorConfig.loaded().debugMessage())
                    .color(ChatColor.DARK_RED)
                    .event(
                            new HoverEvent(
                                    HoverEvent.Action.SHOW_TEXT,
                                    new ComponentBuilder(
                                            TorConfig.loaded().debugHoverMessage()
                                                    .replace("%trigger%", this.triggered)
                                    ).create()
                            )
                    ).create();
            form.getPlayer().spigot().sendMessage(component);
        }
    }

    public abstract void operate(EventForm form);

    private String prepare(String str) {
        str = str.toLowerCase();
        str = this.remove(str, garbage.toCharArray());
        str = this.deduplicate(str);
        return str;
    }

    private String deduplicate(String str) {
        List<Character> chars = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            chars.add(ch);
        }
        int index = 0;
        while (chars.size() > index + 1) {
            if (chars.get(index).equals(chars.get(index + 1))) {
                chars.remove(index + 1);
                continue;
            }
            index++;
        }
        StringBuilder builder = new StringBuilder();
        for (Character character : chars) {
            builder.append(character);
        }
        return builder.toString();
    }

    private String remove(String str, char[] chars) {
        for (Character ch : chars) {
            str = str.replace(ch.toString(), "");
        }
        return str;
    }
}
