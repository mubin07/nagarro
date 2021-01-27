package com.nagarro.service;

import com.nagarro.dto.BranchDto;
import com.nagarro.dto.VaccineDto;
import com.nagarro.exception.AppliedVaccineNotFoundException;
import com.nagarro.exception.ConfirmedVaccineNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {

    List<VaccineDto> getAppliedVaccinationPerBranch(final Long branchId) throws AppliedVaccineNotFoundException;

    List<VaccineDto> getAppliedVaccinationPerDay(final LocalDate appointmentDate) throws AppliedVaccineNotFoundException;

    List<VaccineDto> getAppliedVaccinationPerPeriod(final LocalDate startDate, final LocalDate endDate) throws AppliedVaccineNotFoundException;

    List<VaccineDto> getConfirmedVaccinationPerPeriod(final LocalDate startDate, final LocalDate endDate) throws ConfirmedVaccineNotFoundException;

}
