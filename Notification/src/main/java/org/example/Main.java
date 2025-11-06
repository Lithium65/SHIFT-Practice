package org.example;

import org.example.builder.Notification;
import org.example.builder.NotificationBuilder;
import org.example.builder.SmsNotificationBuilder;
import org.example.factory.impl.SignInSenderFactory;
import org.example.sender.NotificationSender;
import org.example.sender.resolver.SenderResolver;


public class Main {

    public static void main(String[] args) {
        SenderResolver senderResolver = new SenderResolver(new SignInSenderFactory());

        NotificationSender notificationSender = senderResolver.getSender(NotificationType.SMS);
        SmsNotificationBuilder builder = new SmsNotificationBuilder();

       Notification sms = builder
                .to("+375291234678")
                .withMessage("Your code is 123456")
                .build();

        notificationSender.sendNotification(sms);
    }

}