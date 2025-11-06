package org.example.builder;

import org.example.NotificationType;

public class TelegramNotification extends Notification {
    private final String emoji;
    private final byte[] image;
    private static final NotificationType notificationType = NotificationType.TELEGRAM;

    TelegramNotification(String recipient, String message, String emoji, byte[] image) {
        super(recipient, message);
        this.emoji = emoji;
        this.image = image;
    }

    public String getEmoji() {
        return emoji;
    }

    public byte[] getImage() {
        return image;
    }


    @Override
    public String getNotification() {
        StringBuilder sb = new StringBuilder();
        sb.append("To: ").append(getRecipient()).append("\n");
        sb.append("Message: ").append(emoji != null ? emoji + " " : "").append(getMessage()).append("\n");
        sb.append("Image: ").append(image != null ? "attached" : "none");
        return sb.toString();
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }
}
