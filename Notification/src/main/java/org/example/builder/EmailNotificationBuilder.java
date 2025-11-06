package org.example.builder;

import java.io.InputStream;

public class EmailNotificationBuilder implements NotificationBuilder {
  private String recipient;
  private String message;
  private InputStream attachment;
  private String subject;

  public EmailNotificationBuilder to(String recipient) {
    this.recipient = recipient;
    return this;
  }

  public EmailNotificationBuilder withMessage(String message) {
    this.message = message;
    return this;
  }

  public EmailNotificationBuilder withAttachment(InputStream attachment) {
    this.attachment = attachment;
    return this;
  }

  public EmailNotification build() {
    return new EmailNotification(recipient, subject, message, attachment);
  }

  public EmailNotificationBuilder withSubject(String subject) {
    this.subject = subject;
    return this;
  }
}
