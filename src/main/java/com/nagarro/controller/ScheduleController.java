package com.nagarro.controller;

import com.nagarro.dto.ScheduleDto;
import com.nagarro.dto.ScheduleWrapperDto;
import com.nagarro.exception.ScheduleNotFoundException;
import com.nagarro.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    private final Logger LOGGER = LoggerFactory.getLogger(ScheduleController.class);

    @GetMapping(path = "/all")
    public ResponseEntity<ScheduleWrapperDto> getAllSchedules() throws ScheduleNotFoundException {
        LOGGER.info("Getting all schedule information");
        List<ScheduleDto> scheduleDtoList = scheduleService.getAllSchedule();
        ScheduleWrapperDto scheduleWrapperDto = new ScheduleWrapperDto();
        scheduleWrapperDto.setScheduleDtoList(scheduleDtoList);
        LOGGER.info("Successfully retrieved all schedule information");
        return new ResponseEntity<>(scheduleWrapperDto, HttpStatus.OK);
    }
}
