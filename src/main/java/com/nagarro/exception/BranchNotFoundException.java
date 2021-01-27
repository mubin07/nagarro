package com.nagarro.exception;

public class BranchNotFoundException extends RuntimeException {

    public BranchNotFoundException(String message) {
        super(message);
    }
}
