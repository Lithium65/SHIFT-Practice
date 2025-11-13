package org.example.sender.impl;

import org.example.NotificationType;
import org.example.builder.SmsNotification;
import org.example.sender.NotificationSender;

public class SmsSender implements NotificationSender<SmsNotification> {

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.SMS;
    }

    @Override
    public void sendNotification(SmsNotification notification) {
        System.out.println(notification.getNotification());
    }

}
