package com.nagarro.controller;

import com.nagarro.dto.BranchWrapperDto;
import com.nagarro.entity.Branch;
import com.nagarro.exception.BranchException;
import com.nagarro.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity getAllBranches() {
        ResponseEntity responseEntity;
        try {
            List<Branch> branchList = branchService.getAllBranches();
            BranchWrapperDto branchWrapperDto = new BranchWrapperDto();
            branchWrapperDto.setBranchList(branchList);
            responseEntity = new ResponseEntity(branchWrapperDto, HttpStatus.OK);
        } catch (BranchException e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping(path = "/available-vaccine", produces = "application/json")
    public ResponseEntity getAvailableVaccineByBranch() {
        ResponseEntity responseEntity;
        try {
            Map<String, Long> avlVaccineMap = branchService.getAvailableVaccineByBranch();
            responseEntity = new ResponseEntity(avlVaccineMap, HttpStatus.OK);
        } catch (BranchException e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping(path = "/applied-vaccine", produces = "application/json")
    public ResponseEntity getAppliedVaccineByBranch() {
        ResponseEntity responseEntity;
        try {
            Map<String, Long> appVaccineMap = branchService.getAppliedVaccineByBranch();
            responseEntity = new ResponseEntity(appVaccineMap, HttpStatus.OK);
        } catch (BranchException e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}
