package org.example.validator;

import org.example.builder.EmailNotification;
import org.example.builder.Notification;
import org.example.exception.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailNotificationValidator implements NotificationValidator {

    private final List<ExceptionDto> exceptions = new ArrayList<>();

    private final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_+&*-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$");

    @Override
    public void validate(Notification notification) throws NotificationValidationException {
        if ((notification instanceof EmailNotification emailNotification)) {
            if (isMessageEmpty(emailNotification.getMessage())) {
                exceptions.add(new ExceptionDto(ErrorCode.EMPTY_MESSAGE, "Message is empty"));
            }
            validateEmail(emailNotification.getRecipient());
            validateEmail(emailNotification.getSender());

        } else {
            exceptions.add(new ExceptionDto(ErrorCode.INVALID_NOTIFICATION_TYPE, "Invalid Email Notification"));
        }
        if (!exceptions.isEmpty()) {
            throw new MultiValidationException(exceptions);
        }
    }

    private void validateEmail(String email) throws NotificationValidationException {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        if (!matcher.matches()) {
            exceptions.add(new ExceptionDto(ErrorCode.INVALID_EMAIL_FORMAT, "Email pattern does not match"));
        }
    }
}
