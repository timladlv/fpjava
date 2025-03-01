package org.example.chap3comparatorsfilters;

import java.util.List;
import java.util.stream.Stream;

public class FlatMapExample {
    // flatMap removes nesting, many streams from nap can be produced
    // then are combined into a single stream
    public List<String> flatMap(final List<String> phrases) {
        return phrases.stream()
                .flatMap(phrase -> splitWhiteSpace(phrase))
                .toList();
    }

    private static Stream<String> splitWhiteSpace(final String phrase) {
        return Stream.of(phrase.split("\\s+"));
    }
}
