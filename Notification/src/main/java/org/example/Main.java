package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.builder.NotificationBuilder;
import org.example.builder.SmsNotification;
import org.example.factory.impl.SignInSenderFactory;
import org.example.sender.NotificationSender;
import org.example.sender.resolver.SenderResolver;

@Slf4j
public class Main {

    public static void main(String[] args) {
        SenderResolver senderResolver = new SenderResolver(new SignInSenderFactory());

        NotificationSender notificationSender = senderResolver.getSender(NotificationType.SMS);
        NotificationBuilder builder = new NotificationBuilder();
        SmsNotification sms = builder
                .to("+375292564221")
                .withMessage("Your code is 123456")
                .buildSms();

        notificationSender.sendNotification(sms);
    }

}