package com.booking_facility.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.booking_facility.entity.Slot;
import com.booking_facility.repository.SlotRepository;
import com.booking_facility.service.SlotService;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SlotService.class})
@ExtendWith(SpringExtension.class)
class SlotServiceTest {
    @MockBean
    private SlotRepository slotRepository;

    @Autowired
    private SlotService slotService;

    /**
     * Method under test: {@link SlotService#getAllAvailableSlots()}
     */
    @Test
    void testGetAllAvailableSlots() {
        ArrayList<Slot> slotList = new ArrayList<>();
        when(slotRepository.findAll()).thenReturn(slotList);
        List<Slot> actualAllAvailableSlots = slotService.getAllAvailableSlots();
        assertSame(slotList, actualAllAvailableSlots);
        assertTrue(actualAllAvailableSlots.isEmpty());
        verify(slotRepository).findAll();
    }
}

