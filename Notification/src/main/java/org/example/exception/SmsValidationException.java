package org.example.exception;

public class SmsValidationException extends NotificationValidationException {

    public SmsValidationException(String message) {
        super(message);
    }

    public SmsValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
