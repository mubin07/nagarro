package com.nagarro.entity;

import com.nagarro.constants.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "vaccine", schema = "vaccnow")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id")
    private Long vaccineId;

    @Column(name = "patient_email")
    private String patientEmail;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;

    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    @Column(name = "is_applied")
    private Boolean isApplied;

    public Vaccine(String patientEmail, Branch branch, LocalDate appointmentDate, LocalDateTime bookingDate, Slot slot, PaymentMethod paymentMethod, Boolean isApplied) {
        this.patientEmail = patientEmail;
        this.branch = branch;
        this.appointmentDate = appointmentDate;
        this.bookingDate = bookingDate;
        this.slot = slot;
        this.paymentMethod = paymentMethod;
        this.isApplied = isApplied;
    }
}
