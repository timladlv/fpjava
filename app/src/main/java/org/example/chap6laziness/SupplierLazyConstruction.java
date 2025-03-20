package org.example.chap6laziness;

import java.util.function.Supplier;

public class SupplierLazyConstruction {
    private Supplier<Expensive> expensiveSupplier = this::createAndCacheExpensive;

    private synchronized Expensive createAndCacheExpensive() {
        class Factory implements Supplier<Expensive> {
            private final Expensive expensive = new Expensive();

            @Override
            public Expensive get() {
                return expensive;
            }
        }
        // starts as instance of a lambda
        // so this if block is only false once
        if (!(expensiveSupplier instanceof Factory)) {
            expensiveSupplier = new Factory();
        }
        // always returns the Factory's instance
        return expensiveSupplier.get();
    }

    public Expensive getExpensiveSupplier() {
        return expensiveSupplier.get();
    }
}
