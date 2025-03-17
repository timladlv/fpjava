package org.example.chap5execurearound;

import java.io.Closeable;

public interface Resource extends Closeable {
    void action();
    void close();
}
