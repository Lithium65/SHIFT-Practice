package org.example.validator;

import org.example.builder.EmailNotification;
import org.example.builder.Notification;
import org.example.exception.NotificationValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailNotificationValidator implements NotificationValidator {
    private final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_+&*-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$");

    @Override
    public void validate(Notification notification) throws NotificationValidationException {
        if ((notification instanceof EmailNotification emailNotification)) {
            validateEmail(emailNotification.getRecipient());
            validateEmail(emailNotification.getSender());
        } else {
            throw new NotificationValidationException("Invalid Email Notification");
        }
    }

    private void validateEmail(String email) throws NotificationValidationException {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        if (!matcher.matches()) {
            throw new NotificationValidationException("Email pattern does not match");
        }
    }
}
