package org.example.chap4design;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class DelegateInjectionTest {

    @Test
    void testDelegateInjection() {
        DelegateInjection uut = new DelegateInjection(pf -> BigDecimal.ONE);

        BigDecimal stockWorth = uut.calculateStockWorth("GOOG", 1_000);

        assertThat(stockWorth).isEqualTo(new BigDecimal(1_000));
    }

}
