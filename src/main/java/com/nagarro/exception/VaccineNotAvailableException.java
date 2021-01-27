package com.nagarro.exception;

public class VaccineNotAvailableException extends RuntimeException {

    public VaccineNotAvailableException(String message) {
        super(message);
    }
}
