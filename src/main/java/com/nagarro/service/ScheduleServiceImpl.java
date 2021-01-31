package com.nagarro.service;

import com.nagarro.dto.ScheduleDto;
import com.nagarro.entity.Schedule;
import com.nagarro.exception.ScheduleNotFoundException;
import com.nagarro.repository.ScheduleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private MapperService mapperService;

    private final Logger LOGGER = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    public List<ScheduleDto> getAllSchedule() throws ScheduleNotFoundException {
        LOGGER.info("Fetching all schedule from repository");
        List<Schedule> scheduleList = scheduleRepository.findAll();
        if (scheduleList.isEmpty()) {
            throw new ScheduleNotFoundException("No Schedule found.");
        } else {
            LOGGER.info("Successfully fetched all schedule from repository " + scheduleList);
            return mapperService.mapList(scheduleList, ScheduleDto.class);
        }
    }

    public boolean isScheduleAvailable(final ScheduleDto scheduleDto) {
        LOGGER.info("Verifying from repository if slot is available for " + scheduleDto);
        Schedule schedule = scheduleRepository.findBySchedule(scheduleDto.getBranchId(), scheduleDto.getAppointmentDate(), scheduleDto.getSlotId());
        LOGGER.info("Is slot available " + (schedule == null));
        return schedule == null;
    }
}
