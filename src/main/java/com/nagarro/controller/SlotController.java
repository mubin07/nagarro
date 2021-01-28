package com.nagarro.controller;

import com.nagarro.dto.SlotDto;
import com.nagarro.dto.SlotWrapperDto;
import com.nagarro.exception.SlotNotFoundException;
import com.nagarro.service.SlotService;
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

    @GetMapping(path = "/all")
    public ResponseEntity<SlotWrapperDto> getAllSlots() throws SlotNotFoundException {
        List<SlotDto> slotDtoList = slotService.getAllSlots();
        SlotWrapperDto slotWrapperDto = new SlotWrapperDto();
        slotWrapperDto.setSlotDtoList(slotDtoList);
        return new ResponseEntity<>(slotWrapperDto, HttpStatus.OK);
    }
}
