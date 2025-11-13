package org.example.exception;

public class TelegramValidationException extends NotificationValidationException {
    public TelegramValidationException(String message) {
        super(message);
    }

    public TelegramValidationException(String message, Throwable cause) {
        super(message, cause);
    }


}
