package org.example.chap2collections;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterExample {
    /*
    The function is invoked with param word from the stream
    It returns a Predicate the prefix is passed to that function
     */
    private final Function<String, Predicate<String>> startsWithClosure = prefix -> word -> word.startsWith(prefix);

    public List<String> findStartsWith(final List<String> strings, final String prefix) {
        return strings.stream()
                .filter(s -> s.startsWith(prefix))
                .toList();
    }

    /*
    Represents a predicate (boolean-valued function) of one argument.
    This is a functional interface whose functional method is test(Object).
    */
    public long countStartsWith(final List<String> strings, final Predicate<String> predicate) {
        return strings.stream()
                .filter(predicate)
                .count();
    }

    public List<String> findStartsWithViaClosure(final List<String> strings, final String prefix) {
        return strings.stream()
                .filter(startsWithClosure.apply(prefix))
                .toList();
    }

    public Optional<String> findFirst(List<String> strings, String prefix) {
        return findStartsWith(strings, prefix).stream()
                .findFirst();
    }
}
