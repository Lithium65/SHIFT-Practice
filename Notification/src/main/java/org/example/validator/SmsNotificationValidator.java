package org.example.validator;

import org.example.builder.Notification;
import org.example.builder.SmsNotification;
import org.example.exception.ErrorCode;
import org.example.exception.ExceptionDto;
import org.example.exception.MultiValidationException;
import org.example.exception.SmsValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmsNotificationValidator implements NotificationValidator {

    private final List<ExceptionDto> exceptions = new ArrayList<>();

    private final Pattern NUMBER_PATTERN = Pattern.compile("^\\+[0-9]{10,15}$");

    @Override
    public void validate(Notification notification) throws SmsValidationException {
        if ((notification instanceof SmsNotification smsNotification)) {
            if (isMessageEmpty(smsNotification.getMessage())) {
                exceptions.add(new ExceptionDto(ErrorCode.EMPTY_MESSAGE, "Message is empty"));
            }
            validateNumber(smsNotification.getRecipient());
            validateNumber(smsNotification.getSender());
        } else {
            exceptions.add(new ExceptionDto(ErrorCode.INVALID_NOTIFICATION_TYPE, "Notification is not a SmsNotification"));
        }
        if (!exceptions.isEmpty()) {
            throw new MultiValidationException(exceptions);
        }
    }

    private void validateNumber(String number) throws SmsValidationException {
        Matcher matcher = NUMBER_PATTERN.matcher(number);
        if (!matcher.matches()) {
            exceptions.add(new ExceptionDto(ErrorCode.INVALID_NUMBER_FORMAT, "Sms pattern does not match"));
        }
    }
}
