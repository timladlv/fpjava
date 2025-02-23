package org.example.chap2collections;

import java.util.List;
import java.util.function.Function;

public class MapExample {
    public List<String> toUpperCase(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .toList();
    }

    /*
    Represents a function that accepts one argument and produces a result.
    <T> = Function<F, T>

    This is a functional interface whose functional method is apply(Object).
    The input class can be different from the output class
    */
    public List<String> verboseToUpperCase(List<String> strings) {
        return strings.stream()
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.toUpperCase();
                    }
                })
                .toList();
    }

    public List<Integer> verboseWordCount(List<String> strings) {
        return strings.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return s.length();
                    }
                })
                .toList();
    }
}
