package com.nagarro.dto;

import com.nagarro.constants.PaymentMethod;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VaccineDto {

    private Long vaccineId;

    private String patientEmail;

    private BranchDto branch;

    private LocalDate appointmentDate;

    private LocalDateTime bookingDate;

    private SlotDto slot;

    private PaymentMethod paymentMethod;

    private Boolean isApplied;

}
