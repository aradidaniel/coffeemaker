package com.accenture.coffeemaker;

import com.accenture.coffeemaker.exceptions.CoffeeMakerException;
import com.accenture.coffeemaker.interfaces.IBeanTray;
import com.accenture.coffeemaker.interfaces.IDisplay;
import com.accenture.coffeemaker.interfaces.IServeTray;
import com.accenture.coffeemaker.services.CoffeeMaker;
import com.accenture.coffeemaker.services.ResourceManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CoffeeMakerTest {

    private IBeanTray beanTray;
    private IServeTray serveTray;
    private IDisplay display;
    private ResourceManager resourceManager;
    private CoffeeMaker coffeeMaker;

    @BeforeEach
    void setUp() {
        beanTray = mock(IBeanTray.class);
        serveTray = mock(IServeTray.class);
        display = mock(IDisplay.class);
        resourceManager = mock(ResourceManager.class);
        coffeeMaker = new CoffeeMaker(beanTray, serveTray, display, resourceManager);
    }

    @Test
    void testMakeCoffeeSuccess() throws CoffeeMakerException {
        doNothing().when(resourceManager).checkResources();
        doNothing().when(beanTray).decreaseBeans();
        doNothing().when(serveTray).removeCup();

        coffeeMaker.makeCoffee();

        verify(resourceManager).checkResources();
        verify(beanTray).decreaseBeans();
        verify(display).showMessage("Coffee is ready! Enjoy your drink.");
        verify(serveTray).removeCup();
    }

    @Test
    void testMakeCoffeeFailure() throws CoffeeMakerException {
        doThrow(new CoffeeMakerException("No beans available")).when(resourceManager).checkResources();

        coffeeMaker.makeCoffee();

        verify(display).showMessage("No beans available");
    }

    @Test
    void testFillBeanTray() {
        coffeeMaker.fillBeanTray();
        verify(beanTray).fillBeans();
    }

    @Test
    void testPlaceCup() {
        coffeeMaker.placeCup();
        verify(serveTray).placeCup();
    }

    @Test
    void testDisplayStatus() {
        when(beanTray.getBeans()).thenReturn(5);
        when(serveTray.hasCup()).thenReturn(true);

        coffeeMaker.displayStatus();

        verify(display).showMessage("Bean tray has beans for 5 cups.");
        verify(display).showMessage("Cup on serve tray: Yes");
    }
}
