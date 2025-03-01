package org.example.chap3comparatorsfilters;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FlatMapTest {
    private FlatMapExample uut = new FlatMapExample();

    @Test
    void testFlatMap() {
        List<String> phrases = List.of("aaa bbb ccc",
                "dd ee",
                "f g");
        List<String> words = uut.flatMap(phrases);
        assertThat(words).isEqualTo(List.of("aaa",
                "bbb",
                "ccc",
                "dd",
                "ee",
                "f",
                "g"));
    }
}
