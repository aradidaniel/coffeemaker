package com.accenture.coffeemaker.model;

import com.accenture.coffeemaker.interfaces.AvailabilityCheckable;
import com.accenture.coffeemaker.interfaces.IDisplay;

public class Display implements IDisplay, AvailabilityCheckable {

    @Override
    public void checkAvailability() {
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
