package com.accenture.coffeemaker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServeTrayTest {
    private ServeTray serveTray;

    @BeforeEach
    void setUp() {
        serveTray = new ServeTray();
    }

    @Test
    void testPlaceCup() {
        serveTray.placeCup();
        assertTrue(serveTray.hasCup(), "Cup should be on the tray after placing.");
    }

    @Test
    void testCheckAvailabilitySuccess() {
        serveTray.placeCup();
        assertDoesNotThrow(() -> serveTray.checkAvailability(), "No exception should be thrown when a cup is present.");
    }

    @Test
    void testCheckAvailabilityFailure() {
        CoffeeMakerException exception = assertThrows(CoffeeMakerException.class, () -> serveTray.checkAvailability(), "Exception should be thrown when no cup is present.");
        assertEquals("No cup on the serve tray. Please place a cup.", exception.getMessage());
    }

    @Test
    void testRemoveCup() {
        serveTray.placeCup();
        serveTray.removeCup();
        assertFalse(serveTray.hasCup(), "Cup should be removed from the tray.");
    }
}