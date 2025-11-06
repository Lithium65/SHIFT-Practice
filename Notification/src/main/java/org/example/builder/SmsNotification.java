package org.example.builder;

import org.example.NotificationType;

public class SmsNotification extends Notification {
    private static final NotificationType notificationType = NotificationType.SMS;

    SmsNotification(String recipient, String message) {
        super(recipient, message);
    }

    @Override
    public String getNotification() {
        return "To: " + getRecipient() + "\nMessage: " + getMessage();
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

}
