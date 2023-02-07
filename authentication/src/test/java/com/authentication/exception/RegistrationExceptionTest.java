package com.authentication.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class RegistrationExceptionTest {
    /**
     * Method under test: {@link RegistrationException#RegistrationException(String)}
     */
    @Test
    void testConstructor() {
        RegistrationException actualRegistrationException = new RegistrationException("An error occurred");
        assertNull(actualRegistrationException.getCause());
        assertEquals(0, actualRegistrationException.getSuppressed().length);
        assertEquals("An error occurred", actualRegistrationException.getMessage());
        assertEquals("An error occurred", actualRegistrationException.getLocalizedMessage());
    }
}

