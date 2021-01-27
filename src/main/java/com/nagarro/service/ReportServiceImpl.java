package com.nagarro.service;

import com.nagarro.dto.BranchDto;
import com.nagarro.dto.VaccineDto;
import com.nagarro.entity.Vaccine;
import com.nagarro.exception.AppliedVaccineNotFoundException;
import com.nagarro.exception.ConfirmedVaccineNotFoundException;
import com.nagarro.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Autowired
    private MapperService mapperService;

    @Override
    public List<VaccineDto> getAppliedVaccinationPerBranch(final Long branchId) throws AppliedVaccineNotFoundException {
        List<Vaccine> vaccineList = vaccineRepository.findAppliedVaccinePerBranch(branchId);
        if (vaccineList.isEmpty()) {
            throw new AppliedVaccineNotFoundException("Applied vaccine not found for branch id " + branchId);
        } else {
            return mapperService.mapList(vaccineList, VaccineDto.class);
        }
    }

    @Override
    public List<VaccineDto> getAppliedVaccinationPerDay(LocalDate appointmentDate) throws AppliedVaccineNotFoundException {
        List<Vaccine> vaccineList = vaccineRepository.findAppliedVaccinePerDay(appointmentDate);
        if (vaccineList.isEmpty()) {
            throw new AppliedVaccineNotFoundException("Applied vaccine not found for date " + appointmentDate);
        } else {
            return mapperService.mapList(vaccineList, VaccineDto.class);
        }
    }

    @Override
    public List<VaccineDto> getAppliedVaccinationPerPeriod(LocalDate startDate, LocalDate endDate) throws AppliedVaccineNotFoundException {
        List<Vaccine> vaccineList = vaccineRepository.findAppliedVaccinePerPeriod(startDate, endDate);
        if (vaccineList.isEmpty()) {
            throw new AppliedVaccineNotFoundException("Applied vaccine not found for period " + startDate + " & " + endDate);
        } else {
            return mapperService.mapList(vaccineList, VaccineDto.class);
        }
    }

    @Override
    public List<VaccineDto> getConfirmedVaccinationPerPeriod(LocalDate startDate, LocalDate endDate) throws ConfirmedVaccineNotFoundException {
        List<Vaccine> vaccineList = vaccineRepository.findConfirmedVaccinePerPeriod(startDate, endDate);
        if (vaccineList.isEmpty()) {
            throw new ConfirmedVaccineNotFoundException("Confirmed vaccine not found for period " + startDate + " & " + endDate);
        } else {
            return mapperService.mapList(vaccineList, VaccineDto.class);
        }
    }
}
