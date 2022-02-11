package com.example.fooddeliveryservice.exception;

public class CustomException extends RuntimeException {

    private final int errorCode;
    private final String message;

    public CustomException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
