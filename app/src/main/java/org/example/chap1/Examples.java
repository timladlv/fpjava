package org.example.chap1;

import java.math.BigDecimal;
import java.util.List;

public class Examples {

    private static final BigDecimal PRICE_GETS_DISCOUNTED = BigDecimal.valueOf(20);
    private static final BigDecimal DISCOUNT = BigDecimal.valueOf(0.9);

    public BigDecimal discountImperative(final List<BigDecimal> prices) {
        BigDecimal totalDiscounted = BigDecimal.ZERO;
        for (BigDecimal price : prices) {
            if (price.compareTo(PRICE_GETS_DISCOUNTED) > 0) {
                totalDiscounted = totalDiscounted.add(price.multiply(DISCOUNT));
            }
        }
        return totalDiscounted;
    }

    public BigDecimal discountFunctional(final List<BigDecimal> prices) {
        return prices.stream()
                .filter(p -> p.compareTo(PRICE_GETS_DISCOUNTED) > 0)
                .map(p -> p.multiply(DISCOUNT))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
