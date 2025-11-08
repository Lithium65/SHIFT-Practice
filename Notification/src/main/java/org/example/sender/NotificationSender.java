package org.example.sender;

import org.example.NotificationType;
import org.example.builder.Notification;

public interface NotificationSender<T extends Notification> {

    void sendNotification(T notification);

    NotificationType getNotificationType();
}
