package org.example.validator;

import org.example.builder.Notification;
import org.example.builder.TelegramNotification;
import org.example.exception.ErrorCode;
import org.example.exception.ExceptionDto;
import org.example.exception.MultiValidationException;
import org.example.exception.TelegramValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelegramNotificationValidator implements NotificationValidator {

    private final List<ExceptionDto> exceptions = new ArrayList<>();

    private final Pattern USERNAME_PATTERN = Pattern.compile("^(@[a-zA-Z0-9_]{5,32}|\\+?[0-9]{10,15})$");

    @Override
    public void validate(Notification notification) {
        if ((notification instanceof TelegramNotification telegramNotification)) {
            if (isMessageEmpty(telegramNotification.getMessage())) {
                exceptions.add(new ExceptionDto(ErrorCode.EMPTY_MESSAGE, "Message is empty"));
            }
            validateUsername(telegramNotification.getSender());
            validateUsername(telegramNotification.getRecipient());
        } else {
            exceptions.add(new ExceptionDto(ErrorCode.INVALID_NOTIFICATION_TYPE, "Notification is not a TelegramNotification"));
        }
        if (!exceptions.isEmpty()) {
            throw new MultiValidationException(exceptions);
        }
    }

    private void validateUsername(String login) throws TelegramValidationException {
        Matcher matcher = USERNAME_PATTERN.matcher(login);
        if (!matcher.matches()) {
            exceptions.add(new ExceptionDto(ErrorCode.INVALID_USERNAME_FORMAT, "Telegram pattern does not match"));
        }
    }
}
