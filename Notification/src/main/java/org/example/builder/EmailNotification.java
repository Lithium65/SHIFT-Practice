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

    public String getSubject() {
        return subject;
    }

}

