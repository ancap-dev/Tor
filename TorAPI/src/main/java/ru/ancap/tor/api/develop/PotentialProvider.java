package ru.ancap.tor.api.develop;

import java.util.List;

public interface PotentialProvider {

    List<String> potentialFor(String string);

}
