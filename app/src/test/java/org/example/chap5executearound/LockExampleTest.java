package org.example.chap5executearound;

import org.example.chap5execurearound.LockExample;
import org.example.chap5execurearound.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.locks.Lock;

@ExtendWith(MockitoExtension.class)
class LockExampleTest {
    @Mock
    private Lock lock;
    @Mock
    private Resource resource;
    @Test
    void testLocked() {
        LockExample lockExample = new LockExample(lock, resource);

        lockExample.doOp1();
        lockExample.doOp2();
    }
}
