package ru.ancap.tor.api.develop;

import java.util.ArrayList;
import java.util.List;

public class PotentialProviderGroup implements PotentialProvider {

    private final List<PotentialProvider> potentialProviderList;

    public PotentialProviderGroup(PotentialProvider... providers) {
        this(List.of(providers));
    }

    public PotentialProviderGroup(List<PotentialProvider> providerList) {
        this.potentialProviderList = providerList;
    }

    @Override
    public List<String> potentialFor(String string) {
        List<String> potentials = List.of(string);
        for (PotentialProvider provider : this.potentialProviderList) {
            List<String> temp = new ArrayList<>();
            for (String potential : potentials) {
                temp.addAll(provider.potentialFor(potential));
            }
            potentials = temp;
        }
        return potentials;
    }
}
