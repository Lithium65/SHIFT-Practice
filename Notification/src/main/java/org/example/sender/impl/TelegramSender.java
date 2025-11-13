package org.example.sender.impl;

import org.example.NotificationType;
import org.example.builder.TelegramNotification;
import org.example.sender.NotificationSender;

public class TelegramSender implements NotificationSender<TelegramNotification> {

    @Override
    public void sendNotification(TelegramNotification notification) {
        System.out.println(notification.getNotification());
    }

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.TELEGRAM;
    }
}
