package com.accenture.coffeemaker.model;

import com.accenture.coffeemaker.exceptions.CoffeeMakerException;
import com.accenture.coffeemaker.interfaces.AvailabilityCheckable;
import com.accenture.coffeemaker.interfaces.IBeanTray;

public class BeanTray implements IBeanTray, AvailabilityCheckable {
    private int beans;

    public BeanTray() {
        this.beans = 10;
    }

    @Override
    public void checkAvailability() throws CoffeeMakerException {
        if (beans <= 0) {
            throw new CoffeeMakerException("Bean tray is empty. Please refill.");
        }
    }
    @Override
    public void decreaseBeans() {
        beans--;
    }

    @Override
    public void fillBeans() {
        beans = 10;
        System.out.println("Bean tray filled. Ready for 10 cups.");
    }

    @Override
    public int getBeans() {
        return beans;
    }
}
