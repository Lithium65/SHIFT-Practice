package org.example.sender.impl;

import org.example.NotificationType;
import org.example.builder.EmailNotification;
import org.example.sender.NotificationSender;


public class EmailSender implements NotificationSender<EmailNotification> {

    @Override
    public void sendNotification(EmailNotification notification) {
        System.out.println(notification.getNotification());
    }

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.EMAIL;
    }
}
