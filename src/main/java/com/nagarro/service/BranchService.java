package com.nagarro.service;

import com.nagarro.dto.BranchDto;
import com.nagarro.dto.SlotDto;
import com.nagarro.exception.BranchNotFoundException;
import com.nagarro.exception.SlotNotAvailableException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface BranchService {

    List<BranchDto> getAllBranches() throws BranchNotFoundException;

    BranchDto getBranchById(final Long branchId) throws BranchNotFoundException;

    Map<String, Long> getAvailableVaccineByBranch() throws BranchNotFoundException;

    Map<String, Long> getAppliedVaccineByBranch() throws BranchNotFoundException;

    List<SlotDto> getAvailableTimePerBranch(final Long branchId, final LocalDate date) throws SlotNotAvailableException;
}
