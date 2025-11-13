package org.example.exception;

public enum ErrorCode {
    INVALID_EMAIL_FORMAT("001"),
    INVALID_NUMBER_FORMAT("002"),
    INVALID_USERNAME_FORMAT("003"),
    INVALID_NOTIFICATION_TYPE("004"),
    EMPTY_MESSAGE("005");

    private String code;

    ErrorCode(String code) {
        this.code = code;
    }

}
