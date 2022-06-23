package ru.ancap.tor.api.develop;

import java.util.ArrayList;
import java.util.List;

public class SameSymbol implements PotentialProvider {

    private final String fake;
    private final List<String> potentialAbsolutes;

    public SameSymbol(String fake, String... potentialAbsolutes) {
        this(fake, List.of(potentialAbsolutes));
    }

    public SameSymbol(String fake, List<String> potentialAbsolutes) {
        this.fake = fake;
        this.potentialAbsolutes = potentialAbsolutes;
    }

    @Override
    public List<String> potentialFor(String string) {
        List<String> potentials = new ArrayList<>();
        for (String potentialAbsolute : potentialAbsolutes) {
            potentials.add(string.replace(fake, potentialAbsolute));
        }
        return potentials;
    }
}
