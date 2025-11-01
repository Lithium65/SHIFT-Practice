package org.example.decorator;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.NotificationType;
import org.example.sender.NotificationSender;
import org.example.sender.resolver.SenderResolver;

@Slf4j
@RequiredArgsConstructor
public class SenderNotificationDecorator {

    private final SenderResolver senderResolver;

    public void sendNotification(NotificationType currentNotification) {
        NotificationSender notificationSender;
        log.info("Задан тип уведомления: {}", currentNotification);
        notificationSender = senderResolver.getSender(NotificationType.SMS);
        log.info("Уведомления типа {} было успешно отправлено", currentNotification);
        notificationSender.sendNotification();
    }

}