package org.example;

import org.example.controller.ConsoleLoggingStrategy;
import org.example.controller.FileLoggingStrategy;
import org.example.controller.LoggingController;
import org.example.controller.LoggingStrategy;
import org.example.model.ConfigurationManager;
import org.example.model.User;
import org.example.model.UserRole;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();
        configManager.setConfiguration("log_strategy", "console");

        String logFilePath = "log_file.txt";

        LoggingStrategy consoleLoggingStrategy = new ConsoleLoggingStrategy();
        LoggingController consoleLoggingController = new LoggingController(consoleLoggingStrategy);

        LoggingStrategy fileLoggingStrategy = new FileLoggingStrategy(logFilePath);
        LoggingController fileLoggingController = new LoggingController(fileLoggingStrategy);

        Map<String, UserRole> userRoles = new HashMap<>();

        User configManagerUser = User.createConfigurationManager();
        userRoles.put(configManagerUser.getName().toLowerCase(), configManagerUser.getRole());

        User user1 = User.createUser("Andrei", UserRole.ADMIN, "Bucuresti");
        userRoles.put(user1.getName().toLowerCase(), user1.getRole());

        User user2 = User.createUser("Cristian", UserRole.EMPLOYEE, "Timisoara");
        userRoles.put(user2.getName().toLowerCase(), user2.getRole());


        System.out.println("Please enter your name:");

        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        UserRole userRole = userRoles.get(userName.toLowerCase());

        if (userRole != null) {
            switch (userRole) {
                case EMPLOYEE -> {
                    System.out.println("Hello Employee!");
                    break;
                }
                case ADMIN -> {
                    System.out.println("Hello admin!");
                    break;
                }
                case CONFIG_MANAGER -> {
                    System.out.println("Choose where to log the message: ");
                    String choice = scanner.nextLine().toLowerCase();
                    System.out.println("What message do you want to log?");
                    String receivedMessage = scanner.nextLine();
                    switch(choice){
                        case "console" -> {
                            consoleLoggingStrategy.logMessage(receivedMessage);
                            break;
                        }
                        case "file" ->{
                            fileLoggingStrategy.logMessage(receivedMessage);
                            break;
                        }
                        default -> System.out.println("Invalid choice");
                    }
                    break;
                }
                default -> System.out.println("Unexpected user role");
            }
        } else {
            System.out.println("User does not exist");
        }

    }
}