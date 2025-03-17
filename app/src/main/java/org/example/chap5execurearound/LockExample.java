package org.example.chap5execurearound;

import java.util.concurrent.locks.Lock;

public class LockExample {
    private final Lock lock;
    private final Resource resource;

    public LockExample(final Lock lock, final Resource resource) {
        this.lock = lock;
        this.resource = resource;
    }

    public void doOp1() {
        runLocked(lock, resource::action);
    }

    public void doOp2() {
        runLocked(lock, resource::action);
    }

    private void runLocked(final Lock lock, Runnable block) {
        lock.lock();
        try {
            block.run();
        } finally {
            lock.unlock();
        }
    }
}
