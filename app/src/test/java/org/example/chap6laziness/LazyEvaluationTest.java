package org.example.chap6laziness;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LazyEvaluationTest {
    @Spy
    private LazyEvaluation lazyEvaluation;

    @Test
    void evaluationCalledEagerly() {
        // given / when
        lazyEvaluation.eagerEvaluate(lazyEvaluation.evaluate(1), lazyEvaluation.evaluate(2));

        // then
        verify(lazyEvaluation).evaluate(1);
        verify(lazyEvaluation).evaluate(2);
    }

    @Test
    void evaluationCalledOnce() {
        // given / when
        lazyEvaluation.lazilyEvaluate(() -> lazyEvaluation.evaluate(1), () -> lazyEvaluation.evaluate(2));

        // then
        verify(lazyEvaluation).evaluate(1);
        verify(lazyEvaluation, never()).evaluate(2);
    }
}
