package org.example.chap4design;

import java.awt.*;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class DecoratorWithFunctions {
    private Function<Color, Color> filter;

    public DecoratorWithFunctions() {
        setFilters();
    }

    // uses compose to chain functions together - i.e. apply decorator pattern
    // orElse applies an identity transform should the reduce return an Optional empty
    @SafeVarargs
    public final void setFilters(final Function<Color, Color>... filters) {
        this.filter = Stream.of(filters)
                .reduce((filter, next) -> filter.compose(next))
                .orElse(color -> color);
    }
    public Color capture(final Color color) {
        return filter.apply(color);
    }
}
