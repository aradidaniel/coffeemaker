package com.accenture.coffeemaker.resources;

public class Display implements IDisplay, AvailabilityCheckable {

    @Override
    public void checkAvailability() {
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
