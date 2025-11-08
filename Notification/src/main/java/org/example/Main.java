package org.example;

import org.example.builder.Notification;
import org.example.builder.SmsNotification;
import org.example.factory.impl.SignInSenderFactory;
import org.example.sender.NotificationSender;
import org.example.sender.resolver.SenderResolver;
import org.example.validator.NotificationValidator;


public class Main {

  public static void main(String[] args) {
    SenderResolver senderResolver = new SenderResolver(new SignInSenderFactory());
    NotificationSender notificationSender = senderResolver.getSender(NotificationType.SMS);

    NotificationValidator validator = new NotificationValidator();

    Notification sms = new SmsNotification.Builder()
      .to("+375291234678")
      .withMessage("Your code is 123456")
      .build();
    validator.validate(sms, NotificationType.SMS);
    notificationSender.sendNotification(sms);
  }

}