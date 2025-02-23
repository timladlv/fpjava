package org.example.chap1;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExamplesTest {

    private static final String EXPECTED = "67.5";
    private final List<BigDecimal> prices = List.of(
            new BigDecimal("10"),
            new BigDecimal("30"),
            new BigDecimal("17"),
            new BigDecimal("20"),
            new BigDecimal("15"),
            new BigDecimal("18"),
            new BigDecimal("45"),
            new BigDecimal("12")
    );

    @Test
    void discountImperative() {
        Examples uut = new Examples();

        assertThat(uut.discountImperative(prices)).isEqualTo(new BigDecimal(EXPECTED));
    }

    @Test
    void discountFunctional() {
        Examples uut = new Examples();

        assertThat(uut.discountFunctional(prices)).isEqualTo(new BigDecimal(EXPECTED));
    }
}
