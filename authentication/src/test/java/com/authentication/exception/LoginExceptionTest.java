package com.authentication.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class LoginExceptionTest {
    /**
     * Method under test: {@link LoginException#LoginException(String)}
     */
    @Test
    void testConstructor() {
        LoginException actualLoginException = new LoginException("An error occurred");
        assertNull(actualLoginException.getCause());
        assertEquals(0, actualLoginException.getSuppressed().length);
        assertEquals("An error occurred", actualLoginException.getMessage());
        assertEquals("An error occurred", actualLoginException.getLocalizedMessage());
    }
}

