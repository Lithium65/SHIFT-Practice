package org.example.sender;

import org.example.NotificationType;

public interface NotificationSender {

    void sendNotification();

    NotificationType getNotificationType();
}
