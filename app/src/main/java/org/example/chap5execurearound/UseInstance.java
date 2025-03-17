package org.example.chap5execurearound;

@FunctionalInterface
public interface UseInstance <T, X extends Throwable> {
    void accept(T instance) throws X;
}
