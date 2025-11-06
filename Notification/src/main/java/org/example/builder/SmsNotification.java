package org.example.builder;

public class SmsNotification extends Notification {

    protected SmsNotification(String recipient, String message, SmsNotificationBuilder) {
        super(recipient, message);
    }

    @Override
    public String getNotification() {
        return "To: " + getRecipient() + "\nMessage: " + getMessage();
    }

}
