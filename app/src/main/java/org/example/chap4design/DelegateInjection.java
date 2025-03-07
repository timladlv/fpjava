package org.example.chap4design;

import java.math.BigDecimal;
import java.util.function.Function;

public class DelegateInjection {
    // this could be a web service that looks up prices ... or a stub from a test
    private final Function<String, BigDecimal> priceFinder;

    public DelegateInjection(final Function<String, BigDecimal> priceFinder) {
        this.priceFinder = priceFinder;
    }

    public BigDecimal calculateStockWorth(final String shareName, final int count) {
        BigDecimal price = priceFinder.apply(shareName);
        return new BigDecimal(count).multiply(price);
    }
}
