package com.nagarro.exception;

public class AppointmentNotAvailableException extends RuntimeException {

    public AppointmentNotAvailableException(String message) {
        super(message);
    }
}
