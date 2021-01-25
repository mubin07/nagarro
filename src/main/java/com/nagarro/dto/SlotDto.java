package com.nagarro.dto;

import java.time.LocalTime;
import java.util.Objects;

public class SlotDto {

    private String slotId;

    private LocalTime startTime;

    private LocalTime endTime;

    public SlotDto(String slotId, LocalTime startTime, LocalTime endTime) {
        this.slotId = slotId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getSlotId() {
        return slotId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlotDto slotDto = (SlotDto) o;
        return Objects.equals(slotId, slotDto.slotId) &&
                Objects.equals(startTime, slotDto.startTime) &&
                Objects.equals(endTime, slotDto.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slotId, startTime, endTime);
    }

    @Override
    public String toString() {
        return "SlotDto{" +
                "slotId='" + slotId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
