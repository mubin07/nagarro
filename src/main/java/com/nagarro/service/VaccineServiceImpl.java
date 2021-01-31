package com.nagarro.service;

import com.nagarro.dto.BranchDto;
import com.nagarro.dto.ScheduleDto;
import com.nagarro.dto.SlotDto;
import com.nagarro.dto.VaccineDto;
import com.nagarro.entity.Branch;
import com.nagarro.entity.Schedule;
import com.nagarro.entity.Slot;
import com.nagarro.entity.Vaccine;
import com.nagarro.exception.AppointmentNotAvailableException;
import com.nagarro.exception.SlotNotAvailableException;
import com.nagarro.exception.VaccineNotAvailableException;
import com.nagarro.exception.VaccineNotFoundException;
import com.nagarro.repository.BranchRepository;
import com.nagarro.repository.ScheduleRepository;
import com.nagarro.repository.VaccineRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {

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

    @Autowired
    private MapperService mapperService;

    @Autowired
    private ModelMapper modelmapper;

    private final Logger LOGGER = LoggerFactory.getLogger(VaccineServiceImpl.class);

    @Override
    public List<VaccineDto> getAllVaccines() throws VaccineNotFoundException {
        LOGGER.info("Fetching all vaccines from repository");
        List<Vaccine> vaccineList = vaccineRepository.findAll();
        if (vaccineList.isEmpty()) {
            throw new VaccineNotFoundException("No vaccines found.");
        } else {
            LOGGER.info("Successfully fetched all vaccines from repository " + vaccineList);
            return mapperService.mapList(vaccineList, VaccineDto.class);
        }
    }

    @Transactional
    public VaccineDto bookAppointment(VaccineDto vaccineDto) throws VaccineNotAvailableException, SlotNotAvailableException {
        LOGGER.info("Booking an appointment");
        BranchDto branchDto = vaccineDto.getBranch();
        if (branchDto.getAvailableVaccine() == 0) {
            throw new VaccineNotAvailableException("No more vaccines available");
        } else {
            LOGGER.info("Preparing schedule data to check for schedule availability");
            ScheduleDto scheduleDto = getScheduleDto(vaccineDto, branchDto);

            if (!scheduleService.isScheduleAvailable(scheduleDto)) {
                throw new SlotNotAvailableException("Selected slot not available");
            } else {
                Schedule schedule = modelmapper.map(scheduleDto, Schedule.class);
                LOGGER.info("Persisting schedule data " + scheduleDto);
                scheduleRepository.save(schedule);

                LOGGER.info("Updating vaccine availability for the given branch in consideration");
                updateBranchAvailableVaccine(branchDto);
                vaccineDto.setBranch(branchDto);
                branchRepository.save(modelmapper.map(branchDto, Branch.class));
                LOGGER.info("Persisting branch data  with the updated available vaccine information" + branchDto);

                Vaccine vaccine = modelmapper.map(vaccineDto, Vaccine.class);
                LOGGER.info("Persisting vaccine data for the appointment booked " + vaccineDto);
                return modelmapper.map(vaccineRepository.save(vaccine), VaccineDto.class);
            }
        }
    }

    private void updateBranchAvailableVaccine(BranchDto branchDto) {
        branchDto.setAvailableVaccine(branchDto.getAvailableVaccine() - 1);
    }

    private ScheduleDto getScheduleDto(VaccineDto vaccineDto, BranchDto branchDto) {
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setBranchId(branchDto.getBranchId());
        scheduleDto.setAppointmentDate(vaccineDto.getAppointmentDate());
        scheduleDto.setSlotId(vaccineDto.getSlot().getSlotId());
        return scheduleDto;
    }

    @Override
    public List<SlotDto> findBookedTimeSlotForDatePerBranch(Long branchId, LocalDate date) throws SlotNotAvailableException {
        LOGGER.info("Fetching booked time slot for branch id " + branchId + " and date " + date + " from repository");
        List<Slot> slotList = vaccineRepository.findBookedTimeSlotForDatePerBranch(branchId, date);
        if (slotList.isEmpty()) {
            throw new SlotNotAvailableException("No slot available for the selected branch id" + branchId + " and date " + date);
        } else {
            LOGGER.info("Successfully fetched booked time slot for date " + date + " for branch id " + branchId + " from repository " + slotList);
            return mapperService.mapList(slotList, SlotDto.class);
        }
    }

    @Override
    public List<VaccineDto> findUnAppliedVaccineByDate(LocalDate date) throws AppointmentNotAvailableException {
        LOGGER.info("Fetching un applied vaccine by date " + date + " from repository");
        List<Vaccine> vaccineList = vaccineRepository.findUnAppliedVaccineByDate(date);
        if (vaccineList.isEmpty()) {
            throw new AppointmentNotAvailableException("No appointment available to process for the date " + date);
        } else {
            LOGGER.info("Successfully fetched un applied vaccine by date " + date + " from repository " + vaccineList);
            return mapperService.mapList(vaccineList, VaccineDto.class);
        }
    }
}
