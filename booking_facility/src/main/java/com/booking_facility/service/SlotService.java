package com.booking_facility.service;

import com.booking_facility.entity.Slot;
import com.booking_facility.repository.SlotRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotService {
    @Autowired
    private SlotRepository slotRepository;

    public List<Slot> getAllAvailableSlots(){

        List<Slot> slots = slotRepository.findAll();
        return slots;
    }
}
