package org.example.builder;

import org.example.NotificationType;

public class SmsNotification extends Notification {

    private SmsNotification(Builder builder) {
        super(builder.sender, builder.recipient, builder.message, NotificationType.SMS);
    }

    @Override
    public String getNotification() {
        StringBuilder sb = new StringBuilder();
        sb.append("To: ").append(getRecipient()).append("\n");
        sb.append("From: ").append(getSender()).append("\n");
        sb.append("Message: ").append(getMessage());
        return sb.toString();
    }

    public static class Builder {
        private String recipient;
        private String sender;
        private String message;


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

        public SmsNotification build() {
            return new SmsNotification(this);
        }
    }
}
