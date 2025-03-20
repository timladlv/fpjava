package org.example.chap6laziness;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;

class SupplierLazyConstructionTest {
    private final SupplierLazyConstruction uut = new SupplierLazyConstruction();

    @Test
    void heavyweightObjectIsSingleton() throws InterruptedException, ExecutionException {
        // given

        // when
        final List<Expensive> expensives = new ArrayList<>();
        try (ExecutorService executor = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 100; i++) {
                Future<Expensive> submitted = executor.submit(uut::getExpensiveSupplier);
                expensives.add(submitted.get());
            }
        }

        // then
        for (Expensive e : expensives) {
            assertThat(e).isSameAs(expensives.getFirst());
        }
    }
}
