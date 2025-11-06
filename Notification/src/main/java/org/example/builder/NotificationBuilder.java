package org.example.builder;


import java.io.InputStream;

public class NotificationBuilder {
    private String recipient;
    private String message;
    private InputStream attachment;
    private String emoji;
    private byte[] image;

    public NotificationBuilder to(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public NotificationBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public NotificationBuilder withAttachment(InputStream attachment) {
        this.attachment = attachment;
        return this;
    }

    public NotificationBuilder withEmoji(String emoji) {
        this.emoji = emoji;
        return this;
    }

    public NotificationBuilder withImage(byte[] image) {
        this.image = image;
        return this;
    }

    public EmailNotification buildEmail() {
        return new EmailNotification(recipient, message, attachment);
    }

    public TelegramNotification buildTelegram() {
        return new TelegramNotification(recipient, message, emoji, image);
    }

    public SmsNotification buildSms() {
        return new SmsNotification(recipient, message);
    }
}

