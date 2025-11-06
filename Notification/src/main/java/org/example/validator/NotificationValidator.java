package org.example.validator;

import org.example.NotificationType;
import org.example.builder.Notification;

public class NotificationValidator {
  public void validate(Notification notification, NotificationType type) {
    if(!notification.getNotificationType().equals(type)) {
      throw new IllegalArgumentException("Invalid Notification Type");
    }
  }
}

//билдеры вложенные классы
//в конструктор передать билдер, но конструктор будет паблик