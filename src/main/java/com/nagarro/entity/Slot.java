package com.nagarro.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;

@Entity
@Table(name = "slot", schema = "vaccnow")
@Data
public class Slot {

    @Id
    @Column(name = "slot_id", length = 3)
    private String slotId;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

}
