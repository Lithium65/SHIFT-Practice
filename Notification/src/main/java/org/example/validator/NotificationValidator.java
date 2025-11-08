package org.example.validator;

import org.example.NotificationType;
import org.example.builder.Notification;
import org.example.exception.NotificationValidationException;

public class NotificationValidator {

    public void validate(Notification notification, NotificationType expectedType) {
        if (notification == null || expectedType == null) {
            throw new NotificationValidationException("Notification and type must not be null");
        }
        if (!notification.getType().equals(expectedType)) {
            throw new NotificationValidationException("Invalid Notification Type: expected " + expectedType + ", but got " + notification.getType());
        }
    }

}

//билдеры вложенные классы
//в конструктор передать билдер, но конструктор будет паблик