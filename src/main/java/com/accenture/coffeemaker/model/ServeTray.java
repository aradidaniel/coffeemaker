package com.accenture.coffeemaker.model;

import com.accenture.coffeemaker.exceptions.CoffeeMakerException;
import com.accenture.coffeemaker.interfaces.AvailabilityCheckable;
import com.accenture.coffeemaker.interfaces.IServeTray;

public class ServeTray implements IServeTray, AvailabilityCheckable {
    private boolean hasCup;

    public ServeTray() {
        this.hasCup = false;
    }

    @Override
    public void checkAvailability() throws CoffeeMakerException {
        if (!hasCup) {
            throw new CoffeeMakerException("No cup on the serve tray. Please place a cup.");
        }
    }

    @Override
    public void placeCup() {
        hasCup = true;
        System.out.println("Cup placed on the serve tray.");
    }

    @Override
    public void removeCup() {
        hasCup = false;
    }

    @Override
    public boolean hasCup() {
        return hasCup;
    }
}
