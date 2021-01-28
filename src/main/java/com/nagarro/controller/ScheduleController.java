package com.nagarro.controller;

import com.nagarro.dto.ScheduleDto;
import com.nagarro.dto.ScheduleWrapperDto;
import com.nagarro.exception.ScheduleNotFoundException;
import com.nagarro.service.ScheduleService;
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

    @GetMapping(path = "/all")
    public ResponseEntity<ScheduleWrapperDto> getAllBranches() throws ScheduleNotFoundException {
        List<ScheduleDto> scheduleDtoList = scheduleService.getAllSchedule();
        ScheduleWrapperDto scheduleWrapperDto = new ScheduleWrapperDto();
        scheduleWrapperDto.setScheduleDtoList(scheduleDtoList);
        return new ResponseEntity<>(scheduleWrapperDto, HttpStatus.OK);
    }
}
