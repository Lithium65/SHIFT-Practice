package org.example.sender.impl;

import org.example.sender.NotificationSender;

public class SmsSender implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println("SMS отправлено");
    }
}
