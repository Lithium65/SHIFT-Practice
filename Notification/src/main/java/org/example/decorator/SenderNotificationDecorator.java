package org.example.decorator;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.NotificationType;
import org.example.sender.NotificationSender;

@Slf4j
@RequiredArgsConstructor
public class SenderNotificationDecorator implements NotificationSender {

    private final NotificationSender notificationSender;

    @Override
    public void sendNotification() {
        NotificationType notificationType = getNotificationType();
        log.info("Задан тип уведомления: {}", notificationType);
        notificationSender.sendNotification();
        log.info("Уведомления типа {} было успешно отправлено", getNotificationType());
    }

    @Override
    public NotificationType getNotificationType() {
        return notificationSender.getNotificationType();
    }

}