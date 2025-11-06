package org.example.builder;

public class TelegramNotificationBuilder {
  private String recipient;
  private String message;
  private String emoji;
  private byte[] image;

  public TelegramNotificationBuilder to(String recipient) {
    this.recipient = recipient;
    return this;
  }

  public TelegramNotificationBuilder withMessage(String message) {
    this.message = message;
    return this;
  }

  public TelegramNotificationBuilder withEmoji(String emoji) {
    this.emoji = emoji;
    return this;
  }

  public TelegramNotificationBuilder withImage(byte[] image) {
    this.image = image;
    return this;
  }

  public TelegramNotification build() {
    return new TelegramNotification(recipient, message, emoji, image);
  }
}