package chap2collections;

import org.example.chap2collections.FilterExample;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FilterExampleTest {
    public static final List<String> STRING_LIST = List.of("foo", "bar", "baz");
    private final FilterExample uut = new FilterExample();

    @Test
    void testFindStartsWith() {
        List<String> got = uut.findStartsWith(STRING_LIST, "f");
        assertThat(got).isEqualTo(List.of("foo"));
    }


    @ParameterizedTest
    @MethodSource("findStartsWithViaClosure")
    void testFindStartsWithViaClosure(final String prefix, final List<String> expected) {
        List<String> got = uut.findStartsWithViaClosure(STRING_LIST, prefix);
        assertThat(got).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("countsStartsWith")
    void testCountsStartsWith(final Predicate<String> predicate, final long expected) {
        long got = uut.countStartsWith(STRING_LIST, predicate);
        assertThat(got).isEqualTo(expected);
    }

    @Test
    void testFindFirstExists() {
        Optional<String> found = uut.findFirst(STRING_LIST, "b");
        assertThat(found.isPresent()).isTrue();
        assertThat(found.get()).isEqualTo("bar");
    }

    @Test
    void testFindFirstNotExists() {
        Optional<String> found = uut.findFirst(STRING_LIST, "t");
        assertThat(found.isEmpty()).isTrue();
    }


    private static Stream<Arguments> countsStartsWith() {
        Predicate<String> startsWithF = s -> s.startsWith("f");
        Predicate<String> startsWithB = s -> s.startsWith("b");
        return Stream.of(
                Arguments.of(startsWithF, 1),
                Arguments.of(startsWithB, 2)
        );
    }

    private static Stream<Arguments> findStartsWithViaClosure() {
        return Stream.of(
                Arguments.of("f", List.of("foo")),
                Arguments.of("b", List.of("bar", "baz"))
        );
    }
}
