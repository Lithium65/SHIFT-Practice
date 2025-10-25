package org.example.sender.impl;

import org.example.sender.NotificationSender;

public class TelegramSender implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println("Telegram отправлено");
    }
}
