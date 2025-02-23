package chap2collections;

import org.example.chap2collections.FilterExample;
import org.example.chap2collections.ScalarExample;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class ScalarExampleTest {
    private final ScalarExample uut = new ScalarExample();


    @Test
    void testSum() {
        assertThat(uut.sum(List.of(1, 2, 3))).isEqualTo(6);
    }

    @Test
    void testLongestWord() {
        assertThat(uut.longestWord(List.of(
                "", "aaa", "aa"
        ))).isEqualTo(Optional.of("aaa"));
    }

    @Test
    void testLongestWordWithDefault() {
        assertThat(uut.longestWordWithDefault(List.of(
                "", "aaa", "aa"
        ), "aaaa")).isEqualTo("aaaa");
    }

    @Test
    void testJoinedToUpperCase() {
        assertThat(uut.joinedToUpperCase(List.of("tim", "tom")))
                .isEqualTo("TIM, TOM");
    }
}
