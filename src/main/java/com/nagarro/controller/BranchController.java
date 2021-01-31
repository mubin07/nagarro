package com.nagarro.controller;

import com.nagarro.dto.BranchDto;
import com.nagarro.dto.BranchWrapperDto;
import com.nagarro.dto.SlotDto;
import com.nagarro.exception.BranchNotFoundException;
import com.nagarro.service.BranchService;
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
import java.util.Map;

@RestController
@RequestMapping(path = "/api/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    private final Logger LOGGER = LoggerFactory.getLogger(BranchController.class);

    @GetMapping(path = "/all")
    public ResponseEntity<BranchWrapperDto> getAllBranches() throws BranchNotFoundException {
        LOGGER.info("Getting all branch information");
        List<BranchDto> branchList = branchService.getAllBranches();
        LOGGER.info("Successfully retrieved all vaccine information");
        BranchWrapperDto branchWrapperDto = new BranchWrapperDto();
        branchWrapperDto.setBranchDtoList(branchList);
        return new ResponseEntity<>(branchWrapperDto, HttpStatus.OK);
    }

    @GetMapping(path = "/available-vaccine/")
    public ResponseEntity<Map<String, Long>> getAvailableVaccineByBranch() throws BranchNotFoundException {
        LOGGER.info("Getting all available vaccine by branch");
        Map<String, Long> avlVaccineMap = branchService.getAvailableVaccineByBranch();
        LOGGER.info("Successfully retrieved all available vaccine by branch");
        return new ResponseEntity<>(avlVaccineMap, HttpStatus.OK);
    }

    @GetMapping(path = "/applied-vaccine")
    public ResponseEntity<Map<String, Long>> getAppliedVaccineByBranch() throws BranchNotFoundException {
        LOGGER.info("Getting all applied vaccine by branch");
        Map<String, Long> appVaccineMap = branchService.getAppliedVaccineByBranch();
        LOGGER.info("Successfully retrieved all applied vaccine by branch");
        return new ResponseEntity<>(appVaccineMap, HttpStatus.OK);
    }

    @GetMapping(path = "/available-time/branch/{branchId}/date/{date}")
    public ResponseEntity<List<SlotDto>> getAvailableTimeByBranch(@PathVariable("branchId") Long branchId, @PathVariable("date") LocalDate date) throws BranchNotFoundException {
        LOGGER.info("Getting all available time slot for branch " + branchId + " for date " + date);
        List<SlotDto> slotDtoList = branchService.getAvailableTimePerBranch(branchId, date);
        LOGGER.info("Successfully retrieved all available time slot for branch " + branchId + " for date " + date);
        return new ResponseEntity<>(slotDtoList, HttpStatus.OK);
    }
}
