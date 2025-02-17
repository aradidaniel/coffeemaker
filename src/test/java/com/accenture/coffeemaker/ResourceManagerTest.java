package com.accenture.coffeemaker;

import com.accenture.coffeemaker.resources.AvailabilityCheckable;
import com.accenture.coffeemaker.resources.CoffeeMakerException;
import com.accenture.coffeemaker.resources.ResourceManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ResourceManagerTest {
    private ResourceManager resourceManager;
    private AvailabilityCheckable resource1;
    private AvailabilityCheckable resource2;

    @BeforeEach
    void setUp() {
        resource1 = mock(AvailabilityCheckable.class);
        resource2 = mock(AvailabilityCheckable.class);
        resourceManager = new ResourceManager(List.of(resource1, resource2));
    }

    @Test
    void testCheckResourcesSuccess() throws CoffeeMakerException {
        doNothing().when(resource1).checkAvailability();
        doNothing().when(resource2).checkAvailability();

        resourceManager.checkResources();

        verify(resource1).checkAvailability();
        verify(resource2).checkAvailability();
    }

    @Test
    void testCheckResourcesThrowsException() throws CoffeeMakerException {
        doNothing().when(resource1).checkAvailability();
        doThrow(new CoffeeMakerException("Resource unavailable")).when(resource2).checkAvailability();

        CoffeeMakerException exception = assertThrows(CoffeeMakerException.class, resourceManager::checkResources);
        assertEquals("Resource unavailable", exception.getMessage());

        verify(resource1).checkAvailability();
        verify(resource2).checkAvailability();
    }

    @Test
    void testAddResource() throws CoffeeMakerException {
        AvailabilityCheckable newResource = mock(AvailabilityCheckable.class);
        resourceManager.addResource(newResource);

        resourceManager.checkResources();

        verify(resource1).checkAvailability();
        verify(resource2).checkAvailability();
        verify(newResource).checkAvailability();
    }
}
