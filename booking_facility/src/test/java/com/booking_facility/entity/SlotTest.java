package com.booking_facility.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.booking_facility.entity.GameEnum;
import com.booking_facility.entity.Slot;

class SlotTest {
    /**
     * Method under test: {@link Slot#Slot()}
     */
    @Test
    void testConstructor() {
        Slot actualSlot = new Slot();
        assertNull(actualSlot.getGameName());
        assertFalse(actualSlot.isAvailable());
        assertEquals(0, actualSlot.getTotalGround());
        assertEquals(0, actualSlot.getSlot_id());
        assertEquals(0, actualSlot.getGroundNumber());
    }

    /**
     * Method under test: {@link Slot#Slot(int, boolean, int, int, GameEnum)}
     */
    @Test
    void testConstructor2() {
        Slot actualSlot = new Slot(1, true, 10, 1, GameEnum.CRICKET);

        assertEquals(GameEnum.CRICKET, actualSlot.getGameName());
        assertTrue(actualSlot.isAvailable());
        assertEquals(1, actualSlot.getTotalGround());
        assertEquals(1, actualSlot.getSlot_id());
        assertEquals(10, actualSlot.getGroundNumber());
    }
}

