package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.decorator.SenderNotificationDecorator;
import org.example.factory.impl.SignInSenderFactory;
import org.example.sender.NotificationSender;
import org.example.sender.resolver.SenderResolver;

@Slf4j
public class Main {

    public static void main(String[] args) {
        SenderResolver senderResolver = new SenderResolver(new SignInSenderFactory());

        NotificationSender notificationSender = senderResolver.getSender(NotificationType.SMS);
        SenderNotificationDecorator senderNotificationDecorator =
                new SenderNotificationDecorator(notificationSender);

        senderNotificationDecorator.sendNotification();
    }

}