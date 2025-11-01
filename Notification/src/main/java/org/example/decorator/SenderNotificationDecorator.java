package org.example.decorator;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.NotificationType;
import org.example.sender.NotificationSender;

@Slf4j
@RequiredArgsConstructor
public class SenderNotificationDecorator implements NotificationSender {

    private final NotificationSender notificationSender;

    private final NotificationType notificationType;

    @Override
    public void sendNotification() {
        log.info("Задан тип уведомления: {}", notificationType);
        notificationSender.sendNotification();
        log.info("Уведомления типа {} было успешно отправлено", notificationType);
    }

}