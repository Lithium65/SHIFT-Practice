package org.example.builder;

import org.example.NotificationType;

public abstract class Notification{
    private String recipient;
    private String message;

    protected Notification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public abstract String getNotification();

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public abstract NotificationType getNotificationType();
}

