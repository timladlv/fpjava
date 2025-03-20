package org.example.chap6laziness;

import java.util.function.Supplier;

public class LazyEvaluation {
    public Boolean evaluate(final int in) {
        return (in < 1);
    }
    public Boolean eagerEvaluate(Boolean first, Boolean second) {
        return first && second;
    }
    public Boolean lazilyEvaluate(final Supplier<Boolean> first, final Supplier<Boolean> second) {
        return first.get() && second.get();
    }
}
