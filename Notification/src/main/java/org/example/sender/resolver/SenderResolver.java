package org.example.sender.resolver;

import org.example.NotificationType;
import org.example.decorator.SenderNotificationDecorator;
import org.example.factory.SenderFactory;
import org.example.sender.NotificationSender;

import java.util.Map;

public class SenderResolver {

    private final Map<NotificationType, NotificationSender> senderMap;

    public SenderResolver(SenderFactory senderFactory) {
        this.senderMap = senderFactory.getSenderMap();
    }

    public NotificationSender getSender(NotificationType type) {
        return new SenderNotificationDecorator(senderMap.get(type));
    }

}
