package org.example.chap6laziness;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LazyPrimeGenerator {
    public List<Integer> primes(final int start, final int count) {
        int seed = nextPrime(start - 1);
        return Stream.iterate(seed, this::nextPrime)
                .limit(count) // evaluation starts on this expression, starting with the seed
                .toList();
    }

    private int nextPrime(final int number) {
        int next = number + 1;
        if (isPrime(next)) {
            return next;
        }
        return nextPrime(next);
    }

    private boolean isPrime(final int number) {
        return number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(div -> number % div == 0);
    }
}
