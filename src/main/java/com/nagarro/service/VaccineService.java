package com.nagarro.service;

import com.nagarro.dto.ScheduleDto;
import com.nagarro.dto.VaccineDto;
import com.nagarro.entity.*;
import com.nagarro.exception.BranchException;
import com.nagarro.exception.SlotException;
import com.nagarro.exception.VaccineException;
import com.nagarro.repository.BranchRepository;
import com.nagarro.repository.ScheduleRepository;
import com.nagarro.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class VaccineService {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Autowired
    private SlotService slotService;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private BranchService branchService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Transactional
    public VaccineDto bookAppointment(VaccineDto vaccineDto) throws VaccineException, BranchException, SlotException {
        Long branchId = vaccineDto.getBranchId();
        Branch branch = branchService.getBranchById(branchId);
        if (branch.getAvailableVaccine() == 0) {
            throw new VaccineException("No more vaccines available");
        } else {
            ScheduleDto scheduleDto = new ScheduleDto(branch.getBranchId(), vaccineDto.getAppointmentDate(), vaccineDto.getSlotId());
            if (!scheduleService.isScheduleAvailable(scheduleDto)) {
                throw new VaccineException("Selected slot not available");
            } else {
                scheduleRepository.save(new Schedule(new ScheduleId(branch.getBranchId(), vaccineDto.getAppointmentDate(), vaccineDto.getSlotId())));
                Vaccine vaccine = new Vaccine();
                vaccine.setPatientEmail(vaccineDto.getPatientEmail());
                vaccine.setAppointmentDate(vaccineDto.getAppointmentDate());
                vaccine.setBookingDate(vaccineDto.getBookingDate());
                vaccine.setPaymentMethod(vaccineDto.getPaymentMethod());
                vaccine.setSlot(slotService.getSlotById(vaccineDto.getSlotId()));
                vaccine.setBranch(branchRepository.save(new Branch(branch.getBranchId(), branch.getBranchName(), branch.getAvailableVaccine() - 1, branch.getAppliedVaccine() + 1)));
                vaccine = vaccineRepository.save(vaccine);
                vaccineDto.setVaccineId(vaccine.getVaccineId());
                return vaccineDto;
            }
        }
    }
}
