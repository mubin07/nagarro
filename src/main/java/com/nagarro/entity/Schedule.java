package com.nagarro.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "schedule", schema = "vaccnow")
public class Schedule {

    @EmbeddedId
    private ScheduleId scheduleId;

    public Schedule() {
    }

    public Schedule(final ScheduleId scheduleId) {
        this.scheduleId = scheduleId;
    }

    public ScheduleId getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(final ScheduleId scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(scheduleId, schedule.scheduleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleId);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                '}';
    }
}
