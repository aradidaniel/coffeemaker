package com.accenture.coffeemaker;

public class BeanTray implements AvailabilityCheckable{
    private int beans;

    public BeanTray() {
        this.beans = 10; // Initial amount for 10 cups
    }

    @Override
    public void checkAvailability() throws CoffeeMakerException {
        if (beans <= 0) {
            throw new CoffeeMakerException("Bean tray is empty. Please refill.");
        }
    }

    public void decreaseBeans() {
        beans--;
    }

    public void fillBeans() {
        beans = 10;
        System.out.println("Bean tray filled. Ready for 10 cups.");
    }

    public int getBeans() {
        return beans;
    }
}