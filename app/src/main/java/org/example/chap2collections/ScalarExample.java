package org.example.chap2collections;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ScalarExample {

    // following use map-reduce pattern
    public int sum(List<Integer> integers) {
        return integers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public Optional<String> longestWord(List<String> strings) {
        return strings.stream()
                .reduce((a0, a1) -> a0.length() >= a1.length() ? a0 : a1);
    }

    public String longestWordWithDefault(final List<String> strings, final String fallback) {
        return strings.stream()
                .reduce(fallback, (a0, a1) -> a0.length() >= a1.length() ? a0 : a1);
    }

    public String joinedToUpperCase(final List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
    }
}
