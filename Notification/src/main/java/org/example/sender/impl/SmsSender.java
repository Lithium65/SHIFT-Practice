package org.example.sender.impl;

import org.example.NotificationType;
import org.example.sender.NotificationSender;

public class SmsSender implements NotificationSender {

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.SMS;
    }

    @Override
    public void sendNotification() {
        System.out.println("SMS отправлено");
    }

}
