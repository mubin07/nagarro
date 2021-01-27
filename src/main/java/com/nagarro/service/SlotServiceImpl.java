package com.nagarro.service;

import com.nagarro.dto.SlotDto;
import com.nagarro.entity.Slot;
import com.nagarro.exception.SlotNotAvailableException;
import com.nagarro.repository.SlotRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SlotServiceImpl implements SlotService {

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private MapperService mapperService;

    @Autowired
    private ModelMapper modelMapper;

    public List<SlotDto> getAllSlots() throws SlotNotAvailableException {
        List<Slot> slotList = slotRepository.findAll();
        if (slotList.isEmpty()) {
            throw new SlotNotAvailableException("No slots found.");
        } else {
            return mapperService.mapList(slotList, SlotDto.class);
        }
    }

    public SlotDto getSlotById(String slotId) throws SlotNotAvailableException {
        Optional<Slot> optionalSlot = slotRepository.findById(slotId);
        boolean isPresent = optionalSlot.isPresent();
        if (!isPresent) {
            throw new SlotNotAvailableException("Slot not found for slot id " + slotId);
        } else {
            return modelMapper.map(optionalSlot.get(), SlotDto.class);
        }
    }
}
