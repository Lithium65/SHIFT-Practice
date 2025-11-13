package org.example.builder;

import org.example.NotificationType;
import org.example.validator.TelegramNotificationValidator;

public class TelegramNotification extends Notification {
    private final String emoji;
    private final byte[] image;

    private TelegramNotification(Builder builder) {
        super(builder.sender, builder.recipient, builder.message, NotificationType.TELEGRAM);
        this.emoji = builder.emoji;
        this.image = builder.image;
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
        sb.append("From: ").append(getSender()).append("\n");
        sb.append("Message: ").append(emoji != null ? emoji + " " : "").append(getMessage()).append("\n");
        sb.append("Image: ").append(image != null ? "attached" : "none");
        return sb.toString();
    }

    public static class Builder {
        private String recipient;
        private String sender;
        private String message;
        private String emoji;
        private byte[] image;


        public Builder from(String sender) {
            this.sender = sender;
            return this;
        }

        public Builder to(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withEmoji(String emoji) {
            this.emoji = emoji;
            return this;
        }

        public Builder withImage(byte[] image) {
            this.image = image;
            return this;
        }

        public TelegramNotification build() {
            TelegramNotification notification = new TelegramNotification(this);
            TelegramNotificationValidator validator = new TelegramNotificationValidator();
            validator.validate(notification);
            return new TelegramNotification(this);
        }
    }

}
