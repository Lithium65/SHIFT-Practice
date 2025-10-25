package org.example;

import org.example.factory.impl.SignInSenderFactory;
import org.example.sender.resolver.SenderResolver;
import org.example.sender.NotificationSender;

public class Main {
    public static void main(String[] args) {
        SenderResolver senderResolver = new SenderResolver(new SignInSenderFactory());
        NotificationSender notificationSender = senderResolver.getSender(NotificationType.EMAIL);
        notificationSender.sendNotification();
        notificationSender = senderResolver.getSender(NotificationType.SMS);
        notificationSender.sendNotification();
    }
}