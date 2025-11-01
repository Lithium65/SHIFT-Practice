package org.example.decorator;


import lombok.extern.slf4j.Slf4j;
import org.example.NotificationType;
import org.example.sender.NotificationSender;

@Slf4j

public class SenderNotificationDecorator implements NotificationSender {

    private final NotificationSender notificationSender;

    public SenderNotificationDecorator(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

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