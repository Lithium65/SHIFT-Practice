package org.example.sender;

import org.example.NotificationType;
import org.example.builder.Notification;

public interface NotificationSender {

    void sendNotification(Notification notification);

    NotificationType getNotificationType();
}
