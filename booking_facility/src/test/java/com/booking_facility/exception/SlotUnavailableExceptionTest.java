package com.booking_facility.exception;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.booking_facility.exception.SlotUnavailableException;

public class SlotUnavailableExceptionTest {
	 @Test
	    void testConstructor() {
		 SlotUnavailableException actualSlotException = new SlotUnavailableException("An error occurred");
	        assertNull(actualSlotException.getCause());
	        assertEquals(0, actualSlotException.getSuppressed().length);
	        assertEquals("An error occurred", actualSlotException.getMessage());
	        assertEquals("An error occurred", actualSlotException.getLocalizedMessage());
	    }

}

