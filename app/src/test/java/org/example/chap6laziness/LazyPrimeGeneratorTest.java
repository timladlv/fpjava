package org.example.chap6laziness;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LazyPrimeGeneratorTest {
    private final LazyPrimeGenerator uut = new LazyPrimeGenerator();

    @Test
    void testPrimeSequence() {
        // given
        int start = 100;
        int count = 5;

        // when
        List<Integer> primes = uut.primes(start, count);

        // then
        assertThat(primes).isEqualTo(List.of(101, 103, 107, 109, 113));
    }

}
