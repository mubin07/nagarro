package com.nagarro.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "schedule", schema = "vaccnow")
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Column(name = "slot_id")
    private String slotId;
}
