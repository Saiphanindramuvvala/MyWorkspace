package com.authentication.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class PlayerResponseTest {
    /**
     * Method under test: {@link PlayerResponse#PlayerResponse(String)}
     */
    @Test
    void testConstructor() {
        PlayerResponse actualPlayerResponse = new PlayerResponse("ABC123");
        assertEquals("ABC123", actualPlayerResponse.getToken());
        assertFalse(actualPlayerResponse.isValid());
    }
}

