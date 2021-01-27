package com.nagarro.exception;

public class ConfirmedVaccineNotFoundException extends RuntimeException {
    public ConfirmedVaccineNotFoundException(String message) {
        super(message);
    }
}
