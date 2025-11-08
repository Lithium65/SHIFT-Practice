package org.example;

import org.example.builder.EmailNotification;
import org.example.builder.Notification;
import org.example.exception.NotificationValidationException;
import org.example.factory.impl.SignInSenderFactory;
import org.example.sender.NotificationSender;
import org.example.sender.resolver.SenderResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SenderResolver senderResolver = new SenderResolver(new SignInSenderFactory());
        NotificationSender notificationSender = senderResolver.getSender(NotificationType.EMAIL);

        try {
            Notification email = new EmailNotification.Builder()
                    .to("recipient@mail.com")
                    .from("sender@mail.com")
                    .withMessage("Your code is 123456")
                    .build();
            notificationSender.sendNotification(email);
        } catch (NotificationValidationException e) {
            log.error(e.getMessage());
        }
    }

}