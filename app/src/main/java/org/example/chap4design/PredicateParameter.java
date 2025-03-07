package org.example.chap4design;

import java.util.List;
import java.util.function.Predicate;

public class PredicateParameter {
    public int sumValue(final List<Asset> assets, final Predicate<Asset> predicate) {
        return assets.stream()
                .filter(predicate)
                .mapToInt(Asset::value)
                .sum();
    }
}
