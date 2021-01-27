package com.nagarro.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class SlotDto {

    private String slotId;

    private LocalTime startTime;

    private LocalTime endTime;

}
