package com.nagarro.controller;

import com.nagarro.dto.SlotDto;
import com.nagarro.dto.SlotWrapperDto;
import com.nagarro.exception.SlotNotFoundException;
import com.nagarro.service.SlotService;
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
@RequestMapping(path = "/api/slot")
public class SlotController {

    @Autowired
    private SlotService slotService;

    private final Logger LOGGER = LoggerFactory.getLogger(SlotController.class);

    @GetMapping(path = "/all")
    public ResponseEntity<SlotWrapperDto> getAllSlots() throws SlotNotFoundException {
        LOGGER.info("Getting all slot information");
        List<SlotDto> slotDtoList = slotService.getAllSlots();
        SlotWrapperDto slotWrapperDto = new SlotWrapperDto();
        slotWrapperDto.setSlotDtoList(slotDtoList);
        LOGGER.info("Successfully retrieved all slot information");
        return new ResponseEntity<>(slotWrapperDto, HttpStatus.OK);
    }
}
