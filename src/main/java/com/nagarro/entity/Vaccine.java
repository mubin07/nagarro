package com.nagarro.entity;

import com.nagarro.constants.PaymentMethod;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "vaccine", schema = "vaccnow")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Vaccine() {
    }

    public Vaccine(Long vaccineId, String patientEmail, Branch branch, LocalDate appointmentDate, LocalDateTime bookingDate, Slot slot, PaymentMethod paymentMethod) {
        this.vaccineId = vaccineId;
        this.patientEmail = patientEmail;
        this.branch = branch;
        this.appointmentDate = appointmentDate;
        this.bookingDate = bookingDate;
        this.slot = slot;
        this.paymentMethod = paymentMethod;
    }

    public Long getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(final Long vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(final String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(final Branch branch) {
        this.branch = branch;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(final LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(final LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(final Slot slot) {
        this.slot = slot;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(final PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccine vaccine = (Vaccine) o;
        return Objects.equals(vaccineId, vaccine.vaccineId) &&
                Objects.equals(patientEmail, vaccine.patientEmail) &&
                Objects.equals(branch, vaccine.branch) &&
                Objects.equals(appointmentDate, vaccine.appointmentDate) &&
                Objects.equals(bookingDate, vaccine.bookingDate) &&
                Objects.equals(slot, vaccine.slot) &&
                paymentMethod == vaccine.paymentMethod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vaccineId, patientEmail, branch, appointmentDate, bookingDate, slot, paymentMethod);
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "vaccineId=" + vaccineId +
                ", patientEmail='" + patientEmail + '\'' +
                ", branch=" + branch +
                ", appointmentDate=" + appointmentDate +
                ", bookingDate=" + bookingDate +
                ", slot=" + slot +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
