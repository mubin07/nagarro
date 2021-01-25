package com.nagarro.service;

import com.nagarro.entity.Slot;
import com.nagarro.exception.SlotException;
import com.nagarro.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SlotService {

    @Autowired
    private SlotRepository slotRepository;

    public List<Slot> getAllSlots() throws SlotException {
        List<Slot> slots = slotRepository.findAll();
        if (slots.isEmpty()) {
            throw new SlotException("No slots found.");
        } else {
            return slots;
        }
    }

    public Slot getSlotById(String slotId) throws SlotException {
        Optional<Slot> optionalSlot = slotRepository.findById(slotId);
        boolean isPresent = optionalSlot.isPresent();
        if (!isPresent) {
            throw new SlotException("Slot not found for slot id " + slotId);
        } else {
            return optionalSlot.get();
        }
    }
}
