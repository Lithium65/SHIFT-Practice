package org.example.sender.impl;

import org.example.NotificationType;
import org.example.sender.NotificationSender;


public class EmailSender implements NotificationSender {

    @Override
    public void sendNotification() {
        System.out.println("EMAIL отправлено");
    }

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.EMAIL;
    }
}
