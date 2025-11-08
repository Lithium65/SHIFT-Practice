package org.example.builder;

import org.example.NotificationType;
import org.example.validator.EmailNotificationValidator;

import java.io.InputStream;

public class EmailNotification extends Notification {
    private final InputStream attachment;
    private final String subject;

    private EmailNotification(Builder builder) {
        super(builder.sender, builder.recipient, builder.message, NotificationType.EMAIL);
        this.attachment = builder.attachment;
        this.subject = builder.subject;
    }

    @Override
    public String getNotification() {
        StringBuilder sb = new StringBuilder();
        sb.append("To: ").append(getRecipient()).append("\n");
        sb.append("From: ").append(getSender()).append("\n");
        sb.append("Subject: ").append(subject != null ? subject : "(no subject)").append("\n");
        sb.append("Message: ").append(getMessage()).append("\n");
        sb.append("Attachment: ").append(attachment != null ? "attached" : "none");
        return sb.toString();
    }

    public static class Builder {
        private String sender;
        private String recipient;
        private String message;
        private InputStream attachment;
        private String subject;

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

        public Builder withAttachment(InputStream attachment) {
            this.attachment = attachment;
            return this;
        }

        public Builder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public EmailNotification build() {
            EmailNotification notification = new EmailNotification(this);
            EmailNotificationValidator validator = new EmailNotificationValidator();
            validator.validate(notification);
            return notification;
        }


    }

}

