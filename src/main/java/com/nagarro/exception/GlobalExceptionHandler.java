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

    @ExceptionHandler(AppliedVaccineNotFoundException.class)
    protected ResponseEntity<Object> handleAppliedVaccineNotFoundException(AppliedVaccineNotFoundException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(AppointmentNotAvailableException.class)
    protected ResponseEntity<Object> handleAppointmentNotAvailableException(AppointmentNotAvailableException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(BranchNotFoundException.class)
    protected ResponseEntity<Object> handleBranchNotFoundException(BranchNotFoundException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = ConfirmedVaccineNotFoundException.class)
    protected ResponseEntity<Object> handleConfirmedVaccineNotFoundException(ConfirmedVaccineNotFoundException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = SlotNotAvailableException.class)
    protected ResponseEntity<Object> handleSlotNotAvailableException(SlotNotAvailableException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = ScheduleNotFoundException.class)
    protected ResponseEntity<Object> handleScheduleNotFoundException(ScheduleNotFoundException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = VaccineNotAvailableException.class)
    protected ResponseEntity<Object> handleVaccineNotAvailableExceptionException(VaccineNotAvailableException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = VaccineNotFoundException.class)
    protected ResponseEntity<Object> handleVaccineNotFoundException(VaccineNotFoundException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = RuntimeException.class)
    protected ResponseEntity<Object> handleExceptionException(RuntimeException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
