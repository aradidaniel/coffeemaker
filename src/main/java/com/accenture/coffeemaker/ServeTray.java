package com.accenture.coffeemaker;

public class ServeTray implements AvailabilityCheckable{
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

    public void placeCup() {
        hasCup = true;
        System.out.println("Cup placed on the serve tray.");
    }

    public void removeCup() {
        hasCup = false;
    }

    public boolean hasCup() {
        return hasCup;
    }
}