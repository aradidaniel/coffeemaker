package com.accenture.coffeemaker.interfaces;

import com.accenture.coffeemaker.exceptions.CoffeeMakerException;

public interface AvailabilityCheckable {
    void checkAvailability() throws CoffeeMakerException;
}