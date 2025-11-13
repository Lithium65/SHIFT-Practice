package org.example.validator;

import org.example.builder.Notification;
import org.example.exception.NotificationValidationException;

public interface NotificationValidator {
    void validate(Notification notification) throws NotificationValidationException;

    default boolean isMessageEmpty(String message) {
        return (message == null || message.isBlank());
    }
}