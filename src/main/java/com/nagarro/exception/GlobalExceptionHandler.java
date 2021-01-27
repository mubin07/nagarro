package com.nagarro.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BranchNotFoundException.class)
    protected ResponseEntity<Object> handleBranchNotFoundException(BranchNotFoundException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = SlotNotAvailableException.class)
    protected ResponseEntity<Object> handleSlotNotAvailableException(SlotNotAvailableException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = VaccineNotAvailableException.class)
    protected ResponseEntity<Object> handleVaccineNotAvailableExceptionException(VaccineNotAvailableException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = AppliedVaccineNotFoundException.class)
    protected ResponseEntity<Object> handleAppliedVaccineNotFoundExceptionException(AppliedVaccineNotFoundException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = ConfirmedVaccineNotFoundException.class)
    protected ResponseEntity<Object> handleConfirmedVaccineNotFoundExceptionException(ConfirmedVaccineNotFoundException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = RuntimeException.class)
    protected ResponseEntity<Object> handleExceptionException(RuntimeException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
