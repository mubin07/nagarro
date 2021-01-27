package com.nagarro.controller;

import com.nagarro.dto.VaccineDto;
import com.nagarro.exception.SlotNotAvailableException;
import com.nagarro.exception.VaccineNotAvailableException;
import com.nagarro.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/vaccine")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @PostMapping(path = "/book", produces = "application/json")
    public ResponseEntity<VaccineDto> bookVaccinationAppointment(@RequestBody VaccineDto vaccineDto) throws VaccineNotAvailableException, SlotNotAvailableException {
        vaccineDto = vaccineService.bookAppointment(vaccineDto);
        return new ResponseEntity<>(vaccineDto, HttpStatus.CREATED);
    }
}
