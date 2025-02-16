package com.accenture.coffeemaker;

import java.util.List;

public class CoffeeMaker {
    private BeanTray beanTray;
    private ServeTray serveTray;
    private Display display;

    public CoffeeMaker() {
        this.beanTray = new BeanTray();
        this.serveTray = new ServeTray();
        this.display = new Display();
    }

    public void makeCoffee() {
        try {
            checkResourceAvailability();
            beanTray.decreaseBeans();
            display.showMessage("Coffee is ready! Enjoy your drink.");
            serveTray.removeCup();
        } catch (CoffeeMakerException e) {
            display.showMessage(e.getMessage());
        }
    }

    public void fillBeanTray() {
        beanTray.fillBeans();
    }

    public void placeCup() {
        serveTray.placeCup();
    }

    public void displayStatus() {
        display.showMessage("Bean tray has beans for " + beanTray.getBeans() + " cups.");
        display.showMessage("Cup on serve tray: " + (serveTray.hasCup() ? "Yes" : "No"));
    }

    private void checkResourceAvailability() throws CoffeeMakerException {
        List<AvailabilityCheckable> resources = List.of(beanTray, display, serveTray);
        for (AvailabilityCheckable resource : resources) {
            resource.checkAvailability();
        }
    }

    public Display getDisplay() {
        return display;
    }
}