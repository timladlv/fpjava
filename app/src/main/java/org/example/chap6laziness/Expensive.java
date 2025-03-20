package org.example.chap6laziness;

public class Expensive {
    public Expensive() {
        try {
            System.out.println("sleep");
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
