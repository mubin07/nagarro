package com.nagarro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SlotDto {

    private String slotId;

    private LocalTime startTime;

    private LocalTime endTime;

}
