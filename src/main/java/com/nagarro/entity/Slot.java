package com.nagarro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "slot", schema = "vaccnow")
public class Slot {

    @Id
    @Column(name = "slot_id", length = 3)
    private String slotId;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    public Slot() {
    }

    public Slot(final String slotId, final LocalTime startTime, final LocalTime endTime) {
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
        Slot slot = (Slot) o;
        return Objects.equals(slotId, slot.slotId) &&
                Objects.equals(startTime, slot.startTime) &&
                Objects.equals(endTime, slot.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slotId, startTime, endTime);
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId='" + slotId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
