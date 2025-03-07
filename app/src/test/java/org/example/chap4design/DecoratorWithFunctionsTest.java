package org.example.chap4design;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;

class DecoratorWithFunctionsTest {

    private static final Color startColor = new Color(100, 100, 100);

    @Test
    void testIdentity() {
        DecoratorWithFunctions decoratorWithFunctions = new DecoratorWithFunctions();

        Color processed = decoratorWithFunctions.capture(startColor);

        assertThat(processed).isEqualTo(startColor);
    }

    @Test
    void testDecorated() {
        DecoratorWithFunctions decoratorWithFunctions = new DecoratorWithFunctions();
        decoratorWithFunctions.setFilters(Color::brighter);

        Color processed = decoratorWithFunctions.capture(startColor);

        assertThat(processed).isEqualTo(new Color(142, 142, 142));
    }

    @Test
    void testDecoratedCompound() {
        DecoratorWithFunctions decoratorWithFunctions = new DecoratorWithFunctions();
        decoratorWithFunctions.setFilters(Color::brighter, Color::brighter);

        Color processed = decoratorWithFunctions.capture(startColor);

        assertThat(processed).isEqualTo(new Color(202, 202, 202));
    }
}
