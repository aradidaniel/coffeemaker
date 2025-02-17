package com.accenture.coffeemaker.resources;

public interface AvailabilityCheckable {
    void checkAvailability() throws CoffeeMakerException;
}