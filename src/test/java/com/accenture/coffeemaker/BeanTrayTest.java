package com.accenture.coffeemaker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeanTrayTest {
    private BeanTray beanTray;

    @BeforeEach
    void setUp() {
        beanTray = new BeanTray();
    }

    @Test
    void testDecreaseBeans() {
        beanTray.decreaseBeans();
        assertEquals(9, beanTray.getBeans(), "Beans should decrease by 1.");
    }

    @Test
    void testCheckAvailabilitySuccess() {
        assertDoesNotThrow(() -> beanTray.checkAvailability(), "No exception should be thrown when beans are available.");
    }

    @Test
    void testCheckAvailabilityFailure() {
        for (int i = 0; i < 10; i++) {
            beanTray.decreaseBeans();
        }
        CoffeeMakerException exception = assertThrows(CoffeeMakerException.class, () -> beanTray.checkAvailability(), "Exception should be thrown when beans are empty.");
        assertEquals("Bean tray is empty. Please refill.", exception.getMessage());
    }

    @Test
    void testFillBeans() {
        for (int i = 0; i < 10; i++) {
            beanTray.decreaseBeans();
        }
        beanTray.fillBeans();
        assertEquals(10, beanTray.getBeans(), "Beans should be refilled to 10.");
    }
}