package com.nagarro.controller;

import com.nagarro.dto.BranchDto;
import com.nagarro.dto.BranchWrapperDto;
import com.nagarro.dto.SlotDto;
import com.nagarro.exception.BranchNotFoundException;
import com.nagarro.service.BranchService;
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

    @GetMapping(path = "/all")
    public ResponseEntity<BranchWrapperDto> getAllBranches() throws BranchNotFoundException {
        List<BranchDto> branchList = branchService.getAllBranches();
        BranchWrapperDto branchWrapperDto = new BranchWrapperDto();
        branchWrapperDto.setBranchDtoList(branchList);
        return new ResponseEntity<>(branchWrapperDto, HttpStatus.OK);
    }

    @GetMapping(path = "/available-vaccine/")
    public ResponseEntity<Map<String, Long>> getAvailableVaccineByBranch() throws BranchNotFoundException {
        Map<String, Long> avlVaccineMap = branchService.getAvailableVaccineByBranch();
        return new ResponseEntity<>(avlVaccineMap, HttpStatus.OK);
    }

    @GetMapping(path = "/applied-vaccine")
    public ResponseEntity<Map<String, Long>> getAppliedVaccineByBranch() throws BranchNotFoundException {
        Map<String, Long> appVaccineMap = branchService.getAppliedVaccineByBranch();
        return new ResponseEntity<>(appVaccineMap, HttpStatus.OK);
    }

    @GetMapping(path = "/available-time/branch/{branchId}/date/{date}")
    public ResponseEntity<List<SlotDto>> getAvailableTimeByBranch(@PathVariable("branchId") Long branchId, @PathVariable("date") LocalDate date) throws BranchNotFoundException {
        List<SlotDto> slotDtoList = branchService.getAvailableTimePerBranch(branchId, date);
        return new ResponseEntity<>(slotDtoList, HttpStatus.OK);
    }
}
