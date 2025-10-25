package org.example.factory.impl;

import org.example.NotificationType;
import org.example.factory.SenderFactory;
import org.example.sender.NotificationSender;
import org.example.sender.impl.EmailSender;
import org.example.sender.impl.SmsSender;

import java.util.HashMap;
import java.util.Map;

public class SignInSenderFactory implements SenderFactory {

    private final Map<NotificationType, NotificationSender>  senderMap;

    public SignInSenderFactory() {
        this.senderMap = new HashMap<>();
        senderMap.put(NotificationType.EMAIL, new EmailSender());
        senderMap.put(NotificationType.SMS, new SmsSender());
    }

    @Override
    public Map<NotificationType, NotificationSender> getSenderMap() {
        return senderMap;
    }
}
