package org.example.decorator;

import org.example.NotificationType;
import org.example.builder.Notification;
import org.example.sender.NotificationSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SenderNotificationDecorator implements NotificationSender {
    Logger logger = LoggerFactory.getLogger(SenderNotificationDecorator.class);
    private final NotificationSender notificationSender;

    public SenderNotificationDecorator(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    @Override
    public void sendNotification(Notification notification) {
        NotificationType notificationType = getNotificationType();
        logger.info("Задан тип уведомления: {}", notificationType);
        notificationSender.sendNotification(notification);
        logger.info("Уведомления типа {} было успешно отправлено", getNotificationType());
    }

    @Override
    public NotificationType getNotificationType() {
        return notificationSender.getNotificationType();
    }

}