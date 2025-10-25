package org.example.factory;

import org.example.NotificationType;
import org.example.sender.NotificationSender;

import java.util.Map;

public interface SenderFactory {
    Map<NotificationType, NotificationSender> getSenderMap();
}
