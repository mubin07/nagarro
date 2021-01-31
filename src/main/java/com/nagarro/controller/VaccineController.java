package com.nagarro.controller;

import com.nagarro.dto.VaccineDto;
import com.nagarro.dto.VaccineWrapperDto;
import com.nagarro.exception.SlotNotAvailableException;
import com.nagarro.exception.VaccineNotAvailableException;
import com.nagarro.exception.VaccineNotFoundException;
import com.nagarro.service.VaccineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/vaccine")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    private final Logger LOGGER = LoggerFactory.getLogger(VaccineController.class);

    @GetMapping(path = "/all")
    public ResponseEntity<VaccineWrapperDto> getAllVaccines() throws VaccineNotFoundException {
        LOGGER.info("Getting all vaccine information");
        List<VaccineDto> vaccineDtoList = vaccineService.getAllVaccines();
        LOGGER.info("Successfully retrieved all vaccine information");
        VaccineWrapperDto vaccineWrapperDto = new VaccineWrapperDto();
        vaccineWrapperDto.setVaccineDtoList(vaccineDtoList);
        return new ResponseEntity<>(vaccineWrapperDto, HttpStatus.OK);
    }

    @PostMapping(path = "/book", produces = "application/json")
    public ResponseEntity<VaccineDto> bookVaccinationAppointment(@RequestBody VaccineDto vaccineDto) throws VaccineNotAvailableException, SlotNotAvailableException {
        LOGGER.info("Booking vaccination appointment");
        vaccineDto = vaccineService.bookAppointment(vaccineDto);
        LOGGER.info("Successfully booked vaccination appointment");
        return new ResponseEntity<>(vaccineDto, HttpStatus.CREATED);
    }
}
