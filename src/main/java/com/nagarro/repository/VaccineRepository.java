package com.nagarro.repository;

import com.nagarro.entity.Slot;
import com.nagarro.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

    @Query("SELECT v from Vaccine v where isApplied = true and v.branch.branchId = :branchId")
    List<Vaccine> findAppliedVaccinePerBranch(@Param("branchId") Long branchId);

    @Query("SELECT v from Vaccine v where isApplied = true and v.appointmentDate = :appointmentDate")
    List<Vaccine> findAppliedVaccinePerDay(@Param("appointmentDate") LocalDate appointmentDate);

    @Query("SELECT v from Vaccine v where isApplied = true and v.appointmentDate >= :startDate and v.appointmentDate <= :endDate")
    List<Vaccine> findAppliedVaccinePerPeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT v from Vaccine v where isApplied = false and v.appointmentDate >= :startDate and v.appointmentDate <= :endDate")
    List<Vaccine> findConfirmedVaccinePerPeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT v.slot from Vaccine v where v.branch.branchId = :branchId and v.appointmentDate = :date")
    List<Slot> findBookedTimeSlotForDatePerBranch(@Param("branchId") Long branchId, @Param("date") LocalDate date);

    @Query("SELECT v from Vaccine v where isApplied = false and v.appointmentDate = :appointmentDate")
    List<Vaccine> findUnAppliedVaccineByDate(@Param("appointmentDate") LocalDate appointmentDate);
}
