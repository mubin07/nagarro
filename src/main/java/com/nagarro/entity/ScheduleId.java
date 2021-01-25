package com.nagarro.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class ScheduleId implements Serializable {

    private Long branchId;

    private LocalDate appointmentDate;

    private String slotId;

    public ScheduleId() {
    }

    public ScheduleId(final Long branchId, final LocalDate appointmentDate, final String slotId) {
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
        ScheduleId that = (ScheduleId) o;
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
        return "ScheduleId{" +
                "branchId=" + branchId +
                ", appointmentDate=" + appointmentDate +
                ", slotId='" + slotId + '\'' +
                '}';
    }
}
