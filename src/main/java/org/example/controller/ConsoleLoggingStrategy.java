package org.example.controller;

public class ConsoleLoggingStrategy implements LoggingStrategy{
    @Override
    public void logMessage(String message) {
        System.out.println("Console Log: " + message);

    }
}
