package com.nagarro.service;

import com.nagarro.dto.BranchDto;
import com.nagarro.dto.SlotDto;
import com.nagarro.entity.Branch;
import com.nagarro.exception.BranchNotFoundException;
import com.nagarro.exception.SlotNotAvailableException;
import com.nagarro.repository.BranchRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private VaccineService vaccineService;

    @Autowired
    private SlotService slotService;

    @Autowired
    private MapperService mapperService;

    @Autowired
    private ModelMapper modelMapper;

    private final Logger LOGGER = LoggerFactory.getLogger(BranchServiceImpl.class);

    @Override
    public List<BranchDto> getAllBranches() throws BranchNotFoundException {
        LOGGER.info("Fetching all branch information from repository");
        List<Branch> branchList = branchRepository.findAll();
        if (branchList.isEmpty()) {
            throw new BranchNotFoundException("No branches found.");
        } else {
            LOGGER.info("Successfully fetched all branch information from repository " + branchList);
            return mapperService.mapList(branchList, BranchDto.class);
        }
    }

    @Override
    public BranchDto getBranchById(final Long branchId) throws BranchNotFoundException {
        LOGGER.info("Fetching branch information from repository for id " + branchId);
        Optional<Branch> optionalBranch = branchRepository.findById(branchId);
        boolean isPresent = optionalBranch.isPresent();
        if (!isPresent) {
            throw new BranchNotFoundException("Branch not found for branch id " + branchId);
        } else {
            LOGGER.info("Successfully fetched branch information from repository " + optionalBranch.get());
            return modelMapper.map(optionalBranch.get(), BranchDto.class);
        }
    }

    @Override
    public BranchDto getBranchByName(final String branchName) throws BranchNotFoundException {
        LOGGER.info("Fetching branch information from repository for name " + branchName);
        Branch branch = branchRepository.findByName(branchName);
        if (null == branch) {
            throw new BranchNotFoundException("Branch not found for branch name " + branchName);
        } else {
            LOGGER.info("Successfully fetched branch information from repository " + branch);
            return modelMapper.map(branch, BranchDto.class);
        }
    }

    @Override
    public Map<String, Long> getAvailableVaccineByBranch() throws BranchNotFoundException {
        LOGGER.info("Fetching available vaccine by branch from repository");
        List<BranchDto> branchList = getAllBranches();
        return branchList.stream().collect(Collectors.toMap(BranchDto::getBranchName, BranchDto::getAvailableVaccine));
    }

    @Override
    public Map<String, Long> getAppliedVaccineByBranch() throws BranchNotFoundException {
        LOGGER.info("Fetching applied vaccine by branch from repository");
        List<BranchDto> branchList = getAllBranches();
        return branchList.stream().collect(Collectors.toMap(BranchDto::getBranchName, BranchDto::getAppliedVaccine));
    }

    @Override
    public List<SlotDto> getAvailableTimePerBranch(final Long branchId, final LocalDate date) throws SlotNotAvailableException {
        LOGGER.info("Fetching available time slot for branch " + branchId + " for date " + date + " from repository");
        List<SlotDto> bookedSlotDtoList = vaccineService.findBookedTimeSlotForDatePerBranch(branchId, date);
        List<SlotDto> availableSlots = slotService.getAllSlots();
        availableSlots.removeAll(bookedSlotDtoList);
        LOGGER.info("Successfully fetched available time slot for branch " + branchId + " for date " + date + " from repository " + availableSlots);
        return availableSlots;
    }
}
