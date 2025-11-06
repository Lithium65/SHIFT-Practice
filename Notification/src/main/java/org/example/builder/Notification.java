package org.example.builder;

public abstract class Notification {
    private final String recipient;
    private final String message;

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
}

