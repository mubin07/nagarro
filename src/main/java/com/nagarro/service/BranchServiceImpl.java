package com.nagarro.service;

import com.nagarro.dto.BranchDto;
import com.nagarro.dto.SlotDto;
import com.nagarro.entity.Branch;
import com.nagarro.entity.Slot;
import com.nagarro.exception.BranchNotFoundException;
import com.nagarro.exception.SlotNotAvailableException;
import com.nagarro.repository.BranchRepository;
import com.nagarro.repository.VaccineRepository;
import org.modelmapper.ModelMapper;
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

    public List<BranchDto> getAllBranches() throws BranchNotFoundException {
        List<Branch> branchList = branchRepository.findAll();
        if (branchList.isEmpty()) {
            throw new BranchNotFoundException("No branches found.");
        } else {
            return mapperService.mapList(branchList, BranchDto.class);
        }
    }

    public BranchDto getBranchById(final Long branchId) throws BranchNotFoundException {
        Optional<Branch> optionalBranch = branchRepository.findById(branchId);
        boolean isPresent = optionalBranch.isPresent();
        if (!isPresent) {
            throw new BranchNotFoundException("Branch not found for branch id " + branchId);
        } else {
            return modelMapper.map(optionalBranch.get(), BranchDto.class);
        }
    }

    public BranchDto getBranchByName(final String branchName) throws BranchNotFoundException {
        Branch branch = branchRepository.findByName(branchName);
        if (null == branch) {
            throw new BranchNotFoundException("Branch not found for branch name " + branchName);
        } else {
            return modelMapper.map(branch, BranchDto.class);
        }
    }

    public Map<String, Long> getAvailableVaccineByBranch() throws BranchNotFoundException {
        List<BranchDto> branchList = getAllBranches();
        return branchList.stream().collect(Collectors.toMap(BranchDto::getBranchName, BranchDto::getAvailableVaccine));
    }

    public Map<String, Long> getAppliedVaccineByBranch() throws BranchNotFoundException {
        List<BranchDto> branchList = getAllBranches();
        return branchList.stream().collect(Collectors.toMap(BranchDto::getBranchName, BranchDto::getAppliedVaccine));
    }

    @Override
    public List<SlotDto> getAvailableTimePerBranch(final Long branchId, final LocalDate date) throws SlotNotAvailableException {
        List<SlotDto> bookedSlotDtoList = vaccineService.findBookedTimeSlotForDatePerBranch(branchId, date);
        List<SlotDto> availableSlots = slotService.getAllSlots();
        availableSlots.removeAll(bookedSlotDtoList);
        return availableSlots;
    }
}
