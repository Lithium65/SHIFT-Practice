package org.example.sender.impl;

import org.example.NotificationType;
import org.example.builder.Notification;
import org.example.sender.NotificationSender;

public class SmsSender implements NotificationSender {

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.SMS;
    }

    @Override
    public void sendNotification(Notification notification) {
        System.out.println(notification.getNotification());
    }

}
