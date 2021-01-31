package com.nagarro.controller;

import com.nagarro.dto.VaccineDto;
import com.nagarro.dto.VaccineWrapperDto;
import com.nagarro.exception.AppliedVaccineNotFoundException;
import com.nagarro.exception.ConfirmedVaccineNotFoundException;
import com.nagarro.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    private final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);

    @GetMapping(path = "/applied-vaccine/branch/{branchId}")
    public ResponseEntity<VaccineWrapperDto> getAppliedVaccinationPerBranch(@PathVariable("branchId") Long branchId) throws AppliedVaccineNotFoundException {
        LOGGER.info("Getting all applied vaccination for branch " + branchId);
        List<VaccineDto> vaccineDtoList = reportService.getAppliedVaccinationPerBranch(branchId);
        VaccineWrapperDto vaccineWrapperDto = new VaccineWrapperDto();
        vaccineWrapperDto.setVaccineDtoList(vaccineDtoList);
        LOGGER.info("Successfully retrieved all applied vaccination for branch " + branchId);
        return new ResponseEntity<>(vaccineWrapperDto, HttpStatus.OK);
    }

    @GetMapping(path = "/applied-vaccine/date/{date}")
    public ResponseEntity<VaccineWrapperDto> getAppliedVaccinationPerDay(@PathVariable("date") LocalDate date) throws AppliedVaccineNotFoundException {
        LOGGER.info("Getting all applied vaccination for date " + date);
        List<VaccineDto> vaccineDtoList = reportService.getAppliedVaccinationPerDay(date);
        VaccineWrapperDto vaccineWrapperDto = new VaccineWrapperDto();
        vaccineWrapperDto.setVaccineDtoList(vaccineDtoList);
        LOGGER.info("Succesfully retrieved all applied vaccination for date " + date);
        return new ResponseEntity<>(vaccineWrapperDto, HttpStatus.OK);
    }

    @GetMapping(path = "/applied-vaccine/startDate/{startDate}/endDate/{endDate}")
    public ResponseEntity<VaccineWrapperDto> getAppliedVaccinationPerPeriod(@PathVariable("startDate") LocalDate startDate, @PathVariable("endDate") LocalDate endDate) throws AppliedVaccineNotFoundException {
        LOGGER.info("Getting all applied vaccination for period between " + startDate + " and " + endDate);
        List<VaccineDto> vaccineDtoList = reportService.getAppliedVaccinationPerPeriod(startDate, endDate);
        VaccineWrapperDto vaccineWrapperDto = new VaccineWrapperDto();
        vaccineWrapperDto.setVaccineDtoList(vaccineDtoList);
        LOGGER.info("Successfully retrieved all applied vaccination for period between " + startDate + " and " + endDate);
        return new ResponseEntity<>(vaccineWrapperDto, HttpStatus.OK);
    }

    @GetMapping(path = "/confirmed-vaccine/startDate/{startDate}/endDate/{endDate}")
    public ResponseEntity<VaccineWrapperDto> getConfirmedVaccinationPerPeriod(@PathVariable("startDate") LocalDate startDate, @PathVariable("endDate") LocalDate endDate) throws ConfirmedVaccineNotFoundException {
        LOGGER.info("Getting all confirmed vaccination for period between " + startDate + " and " + endDate);
        List<VaccineDto> vaccineDtoList = reportService.getConfirmedVaccinationPerPeriod(startDate, endDate);
        VaccineWrapperDto vaccineWrapperDto = new VaccineWrapperDto();
        vaccineWrapperDto.setVaccineDtoList(vaccineDtoList);
        LOGGER.info("Successfully retrieved all confirmed vaccination for period between " + startDate + " and " + endDate);
        return new ResponseEntity<>(vaccineWrapperDto, HttpStatus.OK);
    }
}
