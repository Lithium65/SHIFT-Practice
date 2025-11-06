package org.example.builder;

public class SmsNotification extends Notification {

    protected SmsNotification(String recipient, String message) {
        super(recipient, message);
    }

    @Override
    public String getNotification() {
        return "To: " + getRecipient() + "\nMessage: " + getMessage();
    }


    @Override
    public SmsNotification build() {
        return new SmsNotification(getRecipient(), getMessage());
    }

    @Override
    public NotificationBuilder withMessage(String message) {
        setMessage(message);
        return this;
    }

    @Override
    public NotificationBuilder to(String recipient) {
        setRecipient(recipient);
        return this;
    }
}
