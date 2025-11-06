package org.example.builder;

public class SmsNotificationBuilder implements NotificationBuilder {
  private String recipient;
  private String message;

  public SmsNotificationBuilder to(String recipient) {
    this.recipient = recipient;
    return this;
  }

  public SmsNotificationBuilder withMessage(String message) {
    this.message = message;
    return this;
  }

  public SmsNotification build() {
    return new SmsNotification(recipient, message);
  }
}
