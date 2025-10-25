package org.example.factory.impl;

import org.example.NotificationType;
import org.example.factory.SenderFactory;
import org.example.sender.NotificationSender;
import org.example.sender.impl.EmailSender;
import org.example.sender.impl.SmsSender;
import org.example.sender.impl.TelegramSender;

import java.util.HashMap;
import java.util.Map;

public class DefaultSenderFactory implements SenderFactory {

    private final Map<NotificationType, NotificationSender>  senderMap;

    public DefaultSenderFactory() {
        this.senderMap = new HashMap<>();
        senderMap.put(NotificationType.EMAIL, new EmailSender());
        senderMap.put(NotificationType.SMS, new SmsSender());
        senderMap.put(NotificationType.TELEGRAM, new TelegramSender());
    }

    @Override
    public Map<NotificationType, NotificationSender> getSenderMap() {
        return senderMap;
    }
}
