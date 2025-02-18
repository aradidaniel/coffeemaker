package com.accenture.coffeemaker;

import com.accenture.coffeemaker.model.BeanTray;
import com.accenture.coffeemaker.model.Display;
import com.accenture.coffeemaker.model.ServeTray;
import com.accenture.coffeemaker.services.CoffeeMaker;
import com.accenture.coffeemaker.services.ResourceManager;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BeanTray beanTray = new BeanTray();
        ServeTray serveTray = new ServeTray();
        Display display = new Display();
        ResourceManager resourceManager = new ResourceManager(List.of(beanTray, serveTray, display));
        CoffeeMaker coffeeMaker = new CoffeeMaker(beanTray, serveTray, display, resourceManager);

        coffeeMaker.displayStatus();
        printMenu();

        while (true) {
            int input = readInput();
            if (input == 1) {
                coffeeMaker.makeCoffee();
            } else if (input == 2) {
                coffeeMaker.fillBeanTray();
            } else if (input == 3) {
                coffeeMaker.placeCup();
            } else if (input == 4) {
                break;
            } else {
                System.out.println("Input not valid");
            }

            coffeeMaker.displayStatus();
            printMenu();
        }

        System.out.println("Coffee machine shut down.");
    }

    private static void printMenu() {
        System.out.println("(1) Make a coffee");
        System.out.println("(2) Fill bean tray");
        System.out.println("(3) Place a cup on the serve tray");
        System.out.println("(4) Shut down coffee machine");
        System.out.println("\nWhat do you want to do?");
    }

    private static int readInput() {
        Scanner scanner = new Scanner(System.in);

        int input;
        try {
            input = scanner.nextInt();
        } catch (Exception e) {
            input = 0;
        }

        return input;
    }
}
