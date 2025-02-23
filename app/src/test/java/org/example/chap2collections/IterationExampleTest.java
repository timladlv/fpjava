package chap2collections;

import org.example.chap2collections.IterationExample;
import org.example.chap2collections.Sink;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class IterationExampleTest {
    public static final List<String> STRING_LIST = List.of("foo", "bar", "baz");
    @Mock
    private Sink sink;

    @InjectMocks
    private IterationExample uut;

    @Test
    void testIterate() {
        uut.iterate(STRING_LIST);

        STRING_LIST.forEach(s -> verify(sink).add(s));
    }

    @Test
    void testVerboseIterate() {
        uut.verboseIterate(STRING_LIST);

        STRING_LIST.forEach(s -> verify(sink).add(s));
    }
}
