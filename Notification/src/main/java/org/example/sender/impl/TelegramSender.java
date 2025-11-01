package org.example.sender.impl;

import org.example.NotificationType;
import org.example.sender.NotificationSender;

public class TelegramSender implements NotificationSender {

    @Override
    public void sendNotification() {
        System.out.println("Telegram отправлено");
    }

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.TELEGRAM;
    }
}
