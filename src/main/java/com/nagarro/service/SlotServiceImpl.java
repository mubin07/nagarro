package com.nagarro.service;

import com.nagarro.dto.SlotDto;
import com.nagarro.entity.Slot;
import com.nagarro.exception.SlotNotAvailableException;
import com.nagarro.repository.SlotRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger LOGGER = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    public List<SlotDto> getAllSlots() throws SlotNotAvailableException {
        LOGGER.info("Fetching all slot from repository");
        List<Slot> slotList = slotRepository.findAll();
        if (slotList.isEmpty()) {
            throw new SlotNotAvailableException("No slots found.");
        } else {
            LOGGER.info("Successfully fetched all slot from repository " + slotList);
            return mapperService.mapList(slotList, SlotDto.class);
        }
    }

    public SlotDto getSlotById(String slotId) throws SlotNotAvailableException {
        LOGGER.info("Fetching slot from repository for slot id " + slotId);
        Optional<Slot> optionalSlot = slotRepository.findById(slotId);
        boolean isPresent = optionalSlot.isPresent();
        if (!isPresent) {
            throw new SlotNotAvailableException("Slot not found for slot id " + slotId);
        } else {
            LOGGER.info("Successfully fetched slot from repository for slot id " + slotId + " : " + optionalSlot.get());
            return modelMapper.map(optionalSlot.get(), SlotDto.class);
        }
    }
}
