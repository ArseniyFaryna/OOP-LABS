package org.example;

public class ConsoleNotification implements NotificationService {

    @Override
    public void notify(String message) {
        System.out.println(message);
    }
}
