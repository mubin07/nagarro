package com.nagarro.service;

import com.nagarro.dto.VaccineDto;
import com.nagarro.entity.Vaccine;
import com.nagarro.exception.AppliedVaccineNotFoundException;
import com.nagarro.exception.ConfirmedVaccineNotFoundException;
import com.nagarro.repository.VaccineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger LOGGER = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Override
    public List<VaccineDto> getAppliedVaccinationPerBranch(final Long branchId) throws AppliedVaccineNotFoundException {
        LOGGER.info("Fetching applied vaccine for branch id " + branchId + " from repository");
        List<Vaccine> vaccineList = vaccineRepository.findAppliedVaccinePerBranch(branchId);
        if (vaccineList.isEmpty()) {
            throw new AppliedVaccineNotFoundException("Applied vaccine not found for branch id " + branchId);
        } else {
            LOGGER.info("Successfully fetched applied vaccine for branch id " + branchId + " from repository " + vaccineList);
            return mapperService.mapList(vaccineList, VaccineDto.class);
        }
    }

    @Override
    public List<VaccineDto> getAppliedVaccinationPerDay(LocalDate appointmentDate) throws AppliedVaccineNotFoundException {
        LOGGER.info("Fetching applied vaccine for date " + appointmentDate + " from repository");
        List<Vaccine> vaccineList = vaccineRepository.findAppliedVaccinePerDay(appointmentDate);
        if (vaccineList.isEmpty()) {
            throw new AppliedVaccineNotFoundException("Applied vaccine not found for date " + appointmentDate);
        } else {
            LOGGER.info("Successfully fetched applied vaccine for date " + appointmentDate + " from repository " + vaccineList);
            return mapperService.mapList(vaccineList, VaccineDto.class);
        }
    }

    @Override
    public List<VaccineDto> getAppliedVaccinationPerPeriod(LocalDate startDate, LocalDate endDate) throws AppliedVaccineNotFoundException {
        LOGGER.info("Fetching applied vaccine for period between " + startDate + " and " + endDate + " from repository");
        List<Vaccine> vaccineList = vaccineRepository.findAppliedVaccinePerPeriod(startDate, endDate);
        if (vaccineList.isEmpty()) {
            throw new AppliedVaccineNotFoundException("Applied vaccine not found for period " + startDate + " & " + endDate);
        } else {
            LOGGER.info("Successfully fetched applied vaccine for period between " + startDate + " and " + endDate + " from repository " + vaccineList);
            return mapperService.mapList(vaccineList, VaccineDto.class);
        }
    }

    @Override
    public List<VaccineDto> getConfirmedVaccinationPerPeriod(LocalDate startDate, LocalDate endDate) throws ConfirmedVaccineNotFoundException {
        LOGGER.info("Fetching confirmed vaccine for period between " + startDate + " and " + endDate + " from repository");
        List<Vaccine> vaccineList = vaccineRepository.findConfirmedVaccinePerPeriod(startDate, endDate);
        if (vaccineList.isEmpty()) {
            throw new ConfirmedVaccineNotFoundException("Confirmed vaccine not found for period " + startDate + " & " + endDate);
        } else {
            LOGGER.info("Successfully fetched confirmed vaccine for period between " + startDate + " and " + endDate + " from repository " + vaccineList);
            return mapperService.mapList(vaccineList, VaccineDto.class);
        }
    }
}
