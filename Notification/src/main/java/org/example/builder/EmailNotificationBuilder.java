package org.example.builder;

import java.io.InputStream;

public class EmailNotificationBuilder {
  private String recipient;
  private String message;
  private InputStream attachment;

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
    return new EmailNotification(recipient, message, attachment);
  }
}
