package com.nagarro.service;

import com.nagarro.entity.Branch;
import com.nagarro.exception.BranchException;
import com.nagarro.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> getAllBranches() throws BranchException {
        List<Branch> branchList = branchRepository.findAll();
        if (branchList.isEmpty()) {
            throw new BranchException("No branches found.");
        } else {
            return branchList;
        }
    }

    public Branch getBranchById(final Long branchId) throws BranchException {
        Optional<Branch> optionalBranch = branchRepository.findById(branchId);
        boolean isPresent = optionalBranch.isPresent();
        if (!isPresent) {
            throw new BranchException("Branch not found for branch id " + branchId);
        } else {
            return optionalBranch.get();
        }
    }

    public Branch getBranchByName(final String branchName) throws BranchException {
        Branch branch = branchRepository.findByName(branchName);
        if (null == branch) {
            throw new BranchException("Branch not found for branch name " + branchName);
        } else {
            return branch;
        }
    }

    public Map<String, Long> getAvailableVaccineByBranch() throws BranchException {
        List<Branch> branchList = getAllBranches();
        return branchList.stream().collect(Collectors.toMap(Branch::getBranchName, Branch::getAvailableVaccine));
    }

    public Map<String, Long> getAppliedVaccineByBranch() throws BranchException {
        List<Branch> branchList = getAllBranches();
        return branchList.stream().collect(Collectors.toMap(Branch::getBranchName, Branch::getAppliedVaccine));
    }
}
