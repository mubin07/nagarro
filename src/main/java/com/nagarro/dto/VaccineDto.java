package com.nagarro.dto;

import com.nagarro.constants.PaymentMethod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class VaccineDto {

    private Long vaccineId;

    private String patientEmail;

    private Long branchId;

    private LocalDate appointmentDate;

    private LocalDateTime bookingDate;

    private String slotId;

    private PaymentMethod paymentMethod;

    public VaccineDto(Long vaccineId, String patientEmail, Long branchId, LocalDate appointmentDate, LocalDateTime bookingDate, String slotId, PaymentMethod paymentMethod) {
        this.vaccineId = vaccineId;
        this.patientEmail = patientEmail;
        this.branchId = branchId;
        this.appointmentDate = appointmentDate;
        this.bookingDate = bookingDate;
        this.slotId = slotId;
        this.paymentMethod = paymentMethod;
    }

    public Long getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Long vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaccineDto that = (VaccineDto) o;
        return Objects.equals(vaccineId, that.vaccineId) &&
                Objects.equals(patientEmail, that.patientEmail) &&
                Objects.equals(branchId, that.branchId) &&
                Objects.equals(appointmentDate, that.appointmentDate) &&
                Objects.equals(bookingDate, that.bookingDate) &&
                Objects.equals(slotId, that.slotId) &&
                paymentMethod == that.paymentMethod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vaccineId, patientEmail, branchId, appointmentDate, bookingDate, slotId, paymentMethod);
    }

    @Override
    public String toString() {
        return "VaccineDto{" +
                "vaccineId=" + vaccineId +
                ", patientEmail='" + patientEmail + '\'' +
                ", branchId=" + branchId +
                ", appointmentDate=" + appointmentDate +
                ", bookingDate=" + bookingDate +
                ", slotId='" + slotId + '\'' +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
