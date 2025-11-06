package org.example.builder;

import java.io.InputStream;

public class EmailNotification extends Notification {
    private final InputStream attachment;
    private final String subject;

    public EmailNotification(String recipient, String subject,  String message, InputStream attachment) {
        super(recipient, message);
        this.attachment = attachment;
        this.subject = subject;
    }

    public InputStream getAttachment() {
        return attachment;
    }

    @Override
    public String getNotification() {
        StringBuilder sb = new StringBuilder();
        sb.append("To: ").append(getRecipient()).append("\n");
        sb.append("Message: ").append(getMessage()).append("\n");
        sb.append("Attachment: ").append(attachment != null ? "attached" : "none");
        return sb.toString();
    }

    @Override
    public EmailNotification build() {
        return new EmailNotification(getRecipient(), getSubject(), getMessage(), getAttachment());
    }

    @Override
    public NotificationBuilder withMessage(String message) {
        setMessage(message);
        return this;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public NotificationBuilder to(String recipient) {
        setRecipient(recipient);
        return this;
    }
}

