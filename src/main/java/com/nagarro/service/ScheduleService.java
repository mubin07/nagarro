package com.nagarro.service;

import com.nagarro.dto.ScheduleDto;

public interface ScheduleService {

    boolean isScheduleAvailable(final ScheduleDto scheduleDto);
}
