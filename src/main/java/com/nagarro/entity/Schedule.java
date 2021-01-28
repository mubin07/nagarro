package com.nagarro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "schedule", schema = "vaccnow")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Column(name = "slot_id")
    private String slotId;

    public Schedule(Long branchId, LocalDate appointmentDate, String slotId) {
        this.branchId = branchId;
        this.appointmentDate = appointmentDate;
        this.slotId = slotId;
    }
}
