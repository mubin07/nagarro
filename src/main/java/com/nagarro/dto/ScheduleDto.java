package com.nagarro.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ScheduleDto {

    private Long scheduleId;

    private Long branchId;

    private LocalDate appointmentDate;

    private String slotId;

}
