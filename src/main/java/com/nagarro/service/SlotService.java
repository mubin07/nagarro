package com.nagarro.service;

import com.nagarro.dto.SlotDto;
import com.nagarro.exception.SlotNotAvailableException;

import java.util.List;

public interface SlotService {

    List<SlotDto> getAllSlots() throws SlotNotAvailableException;

    SlotDto getSlotById(String slotId) throws SlotNotAvailableException;
}
