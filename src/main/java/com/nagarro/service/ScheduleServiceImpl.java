package com.nagarro.service;

import com.nagarro.dto.ScheduleDto;
import com.nagarro.entity.Schedule;
import com.nagarro.exception.ScheduleNotFoundException;
import com.nagarro.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private MapperService mapperService;

    public List<ScheduleDto> getAllSchedule() throws ScheduleNotFoundException {
        List<Schedule> scheduleList = scheduleRepository.findAll();
        if (scheduleList.isEmpty()) {
            throw new ScheduleNotFoundException("No Schedule found.");
        } else {
            return mapperService.mapList(scheduleList, ScheduleDto.class);
        }
    }

    public boolean isScheduleAvailable(final ScheduleDto scheduleDto) {
        Schedule schedule = scheduleRepository.findBySchedule(scheduleDto.getBranchId(), scheduleDto.getAppointmentDate(), scheduleDto.getSlotId());
        return schedule == null;
    }
}
