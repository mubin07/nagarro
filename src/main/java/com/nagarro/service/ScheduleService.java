package com.nagarro.service;

import com.nagarro.dto.ScheduleDto;
import com.nagarro.exception.ScheduleNotFoundException;

import java.util.List;

public interface ScheduleService {

    List<ScheduleDto> getAllSchedule() throws ScheduleNotFoundException;

    boolean isScheduleAvailable(final ScheduleDto scheduleDto);
}
