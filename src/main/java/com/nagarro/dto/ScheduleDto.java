package com.nagarro.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ScheduleDto {

    private Long branchId;

    private LocalDate appointmentDate;

    private String slotId;

    public ScheduleDto(final Long branchId, final LocalDate appointmentDate, final String slotId) {
        this.branchId = branchId;
        this.appointmentDate = appointmentDate;
        this.slotId = slotId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public String getSlotId() {
        return slotId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleDto that = (ScheduleDto) o;
        return Objects.equals(branchId, that.branchId) &&
                Objects.equals(appointmentDate, that.appointmentDate) &&
                Objects.equals(slotId, that.slotId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, appointmentDate, slotId);
    }

    @Override
    public String toString() {
        return "ScheduleDto{" +
                "branchId=" + branchId +
                ", appointmentDate=" + appointmentDate +
                ", slotId='" + slotId + '\'' +
                '}';
    }
}
