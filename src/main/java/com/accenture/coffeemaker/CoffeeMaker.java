package com.accenture.coffeemaker;

import com.accenture.coffeemaker.resources.*;

public class CoffeeMaker {
    private final IBeanTray beanTray;
    private final IServeTray serveTray;
    private final IDisplay display;
    private final ResourceManager resourceManager;

    public CoffeeMaker(IBeanTray beanTray, IServeTray serveTray, IDisplay display, ResourceManager resourceManager) {
        this.beanTray = beanTray;
        this.serveTray = serveTray;
        this.display = display;
        this.resourceManager = resourceManager;
    }

    public void makeCoffee() {
        try {
            resourceManager.checkResources();
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
}
