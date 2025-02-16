package com.accenture.coffeemaker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeMakerIntegrationTest {
    private CoffeeMaker coffeeMaker;

    @BeforeEach
    void setUp() {
        coffeeMaker = new CoffeeMaker();
    }

    @Test
    void testMakeCoffeeSuccess() {
        coffeeMaker.placeCup();
        assertDoesNotThrow(() -> coffeeMaker.makeCoffee(), "Coffee should be made successfully when beans and cup are available.");
    }

    @Test
    void testMakeCoffeeFailureNoBeans() {
        for (int i = 0; i < 11; i++) {
            coffeeMaker.placeCup();
            coffeeMaker.makeCoffee();
        }
        assertEquals("Bean tray is empty. Please refill.", coffeeMaker.getDisplay().getLastMessage());
    }

    @Test
    void testMakeCoffeeFailureNoCup() {
        coffeeMaker.makeCoffee();
        assertEquals("No cup on the serve tray. Please place a cup.", coffeeMaker.getDisplay().getLastMessage());
    }

    @Test
    void testFillBeanTray() {
        for (int i = 0; i < 10; i++) {
            coffeeMaker.makeCoffee();
        }
        coffeeMaker.fillBeanTray();
        assertDoesNotThrow(() -> coffeeMaker.makeCoffee(), "Coffee should be made successfully after refilling beans.");
    }


}