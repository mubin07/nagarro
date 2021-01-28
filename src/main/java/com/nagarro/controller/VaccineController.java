package com.nagarro.controller;

import com.nagarro.dto.VaccineDto;
import com.nagarro.dto.VaccineWrapperDto;
import com.nagarro.exception.SlotNotAvailableException;
import com.nagarro.exception.VaccineNotAvailableException;
import com.nagarro.exception.VaccineNotFoundException;
import com.nagarro.service.VaccineService;
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

    @GetMapping(path = "/all")
    public ResponseEntity<VaccineWrapperDto> getAllBranches() throws VaccineNotFoundException {
        List<VaccineDto> vaccineDtoList = vaccineService.getAllVaccines();
        VaccineWrapperDto vaccineWrapperDto = new VaccineWrapperDto();
        vaccineWrapperDto.setVaccineDtoList(vaccineDtoList);
        return new ResponseEntity<>(vaccineWrapperDto, HttpStatus.OK);
    }

    @PostMapping(path = "/book", produces = "application/json")
    public ResponseEntity<VaccineDto> bookVaccinationAppointment(@RequestBody VaccineDto vaccineDto) throws VaccineNotAvailableException, SlotNotAvailableException {
        vaccineDto = vaccineService.bookAppointment(vaccineDto);
        return new ResponseEntity<>(vaccineDto, HttpStatus.CREATED);
    }
}
