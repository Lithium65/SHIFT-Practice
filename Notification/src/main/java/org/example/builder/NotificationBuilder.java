package org.example.builder;

public interface NotificationBuilder {

    NotificationBuilder to(String recipient);

    NotificationBuilder withMessage(String message);

    Notification build();

}

