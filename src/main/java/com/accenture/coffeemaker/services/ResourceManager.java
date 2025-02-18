package com.accenture.coffeemaker.services;

import com.accenture.coffeemaker.exceptions.CoffeeMakerException;
import com.accenture.coffeemaker.interfaces.AvailabilityCheckable;

import java.util.ArrayList;
import java.util.List;

public class ResourceManager {
    private final List<AvailabilityCheckable> resources;

    public ResourceManager(List<AvailabilityCheckable> initialResources) {
        this.resources = new ArrayList<>(initialResources);
    }

    public void checkResources() throws CoffeeMakerException {
        for (AvailabilityCheckable resource : resources) {
            resource.checkAvailability();
        }
    }

}
