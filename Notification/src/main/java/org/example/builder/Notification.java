package org.example.builder;

import org.example.NotificationType;

public abstract class Notification {
    private final String sender;
    private final String recipient;
    private final String message;
    private final NotificationType type;

    protected Notification(String sender, String recipient, String message, NotificationType type) {
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.type = type;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public NotificationType getType() {
        return type;
    }

    public abstract String getNotification();


}

