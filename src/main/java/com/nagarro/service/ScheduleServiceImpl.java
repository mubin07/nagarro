package com.nagarro.service;

import com.nagarro.dto.ScheduleDto;
import com.nagarro.entity.Schedule;
import com.nagarro.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public boolean isScheduleAvailable(final ScheduleDto scheduleDto) {
        Schedule schedule = scheduleRepository.findBySchedule(scheduleDto.getBranchId(), scheduleDto.getAppointmentDate(), scheduleDto.getSlotId());
        return schedule == null;
    }
}
