package org.example.builder;


import java.io.InputStream;

public interface NotificationBuilder {
//    private String recipient;
//    private String message;
//    private InputStream attachment;
//    private String emoji;
//    private byte[] image;

    NotificationBuilder to(String recipient);

    NotificationBuilder withMessage(String message);

    Notification build();

//    public TelegramNotification build() {
//        return new TelegramNotification(recipient, message, emoji, image);
//    }
//
//    public SmsNotification build() {
//        return new SmsNotification(recipient, message);
//    }
}

