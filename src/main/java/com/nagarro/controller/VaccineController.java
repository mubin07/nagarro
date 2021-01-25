package com.nagarro.controller;

import com.nagarro.dto.VaccineDto;
import com.nagarro.exception.BranchException;
import com.nagarro.exception.SlotException;
import com.nagarro.exception.VaccineException;
import com.nagarro.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/vaccine")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @PostMapping(path = "/book", produces = "application/json")
    public ResponseEntity bookVaccinationAppointment(@RequestBody VaccineDto vaccineDto) {
        ResponseEntity responseEntity;
        try {
            vaccineDto = vaccineService.bookAppointment(vaccineDto);
            responseEntity = new ResponseEntity(vaccineDto, HttpStatus.CREATED);
        } catch (VaccineException | BranchException | SlotException e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
