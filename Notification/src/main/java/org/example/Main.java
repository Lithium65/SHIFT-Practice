package org.example;

import org.example.builder.EmailNotification;
import org.example.builder.Notification;
import org.example.exception.MultiValidationException;
import org.example.factory.impl.DefaultSenderFactory;
import org.example.sender.NotificationSender;
import org.example.sender.resolver.SenderResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SenderResolver senderResolver = new SenderResolver(new DefaultSenderFactory());
        NotificationSender notificationSender = senderResolver.getSender(NotificationType.EMAIL);

        Thread.currentThread().setUncaughtExceptionHandler((t, e) -> {
            if (e instanceof MultiValidationException exception) {
                exception.getExceptions().forEach(exc -> log.error("{} - {}", exc.errorCode(), exc.message()));
            } else {
                log.error(e.getMessage());
            }
        });

        Notification email = new EmailNotification.Builder()
                .to("recipient@mail.com")
                .from("recipient@mail.com")
                .withMessage("gowtigj")
                .build();
        notificationSender.sendNotification(email);
    }
}