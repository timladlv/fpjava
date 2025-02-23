package org.example.chap2collections;

import java.util.List;
import java.util.function.Consumer;

public class IterationExample {
    private final Sink sink;

    public IterationExample(Sink sink) {
        this.sink = sink;
    }

    public void iterate(List<String> strings) {
        strings.forEach(sink::add);
    }

    /*
    Represents an operation that accepts a single input argument and returns no result. Unlike most other functional,
    Consumer is expected to operate via side-effects.

    Any interface with a Single Abstract Method) is a functional interface, and its implementation
    may be treated as lambda expressions.

    This is a functional interface whose functional method is accept(Object).
    */
    public void verboseIterate(List<String> strings) {
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                sink.add(s);
            }
        });
    }
}
