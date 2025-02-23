package chap2collections;

import org.example.chap2collections.MapExample;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MapExampleTest {
    private final MapExample uut = new MapExample();

    @Test
    void toUpperCase() {
        List<String> strings = uut.toUpperCase(List.of("foo", "bar", "baz"));

        assertThat(strings).isEqualTo(List.of("FOO", "BAR", "BAZ"));
    }

    @Test
    void toVerboseUpperCase() {
        List<String> strings = uut.verboseToUpperCase(List.of("foo", "bar", "baz"));

        assertThat(strings).isEqualTo(List.of("FOO", "BAR", "BAZ"));
    }

    @Test
    void wordLength() {
        List<Integer> counts = uut.verboseWordCount(List.of("a", "aa", "aaa"));

        assertThat(counts).isEqualTo(List.of(1, 2, 3));
    }
}
