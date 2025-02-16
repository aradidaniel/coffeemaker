package com.accenture.coffeemaker;

public class Display implements AvailabilityCheckable{

    private String lastMessage;

    @Override
    public void checkAvailability() {
        // No exception thrown for now
    }

    public void showMessage(String message) {
        this.lastMessage = message;
        System.out.println(message);
    }

    public String getLastMessage() {
        return lastMessage;
    }
}