package com.nagarro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {

    private Long scheduleId;

    private Long branchId;

    private LocalDate appointmentDate;

    private String slotId;

}
