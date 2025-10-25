package org.example.sender.impl;

import org.example.sender.NotificationSender;

public class EmailSender implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println("EMAIL отправлено");
    }
}
