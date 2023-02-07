package com.booking_facility.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.booking_facility.vo.PlayerResponse;

class PlayerResponseTest {
    /**
     * Method under test: {@link PlayerResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new PlayerResponse()).canEqual("Other"));
    }

    /**
     * Method under test: {@link PlayerResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        PlayerResponse playerResponse = new PlayerResponse();

        PlayerResponse playerResponse1 = new PlayerResponse();
        playerResponse1.setId("42");
        playerResponse1.setToken("ABC123");
        playerResponse1.setValid(true);
        assertTrue(playerResponse.canEqual(playerResponse1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link PlayerResponse}
     *   <li>{@link PlayerResponse#setId(String)}
     *   <li>{@link PlayerResponse#setToken(String)}
     *   <li>{@link PlayerResponse#setValid(boolean)}
     *   <li>{@link PlayerResponse#toString()}
     *   <li>{@link PlayerResponse#getId()}
     *   <li>{@link PlayerResponse#getToken()}
     *   <li>{@link PlayerResponse#isValid()}
     * </ul>
     */
    @Test
    void testConstructor() {
        PlayerResponse actualPlayerResponse = new PlayerResponse();
        actualPlayerResponse.setId("42");
        actualPlayerResponse.setToken("ABC123");
        actualPlayerResponse.setValid(true);
        String actualToStringResult = actualPlayerResponse.toString();
        assertEquals("42", actualPlayerResponse.getId());
        assertEquals("ABC123", actualPlayerResponse.getToken());
        assertTrue(actualPlayerResponse.isValid());
        assertEquals("PlayerResponse(token=ABC123, isValid=true, id=42)", actualToStringResult);
    }

    /**
     * Method under test: {@link PlayerResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setId("42");
        playerResponse.setToken("ABC123");
        playerResponse.setValid(true);
        assertNotEquals(playerResponse, null);
    }

    /**
     * Method under test: {@link PlayerResponse#equals(Object)}
     */
    @Test
    void testEquals2() {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setId("42");
        playerResponse.setToken("ABC123");
        playerResponse.setValid(true);
        assertNotEquals(playerResponse, "Different type to PlayerResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PlayerResponse#equals(Object)}
     *   <li>{@link PlayerResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setId("42");
        playerResponse.setToken("ABC123");
        playerResponse.setValid(true);
        assertEquals(playerResponse, playerResponse);
        int expectedHashCodeResult = playerResponse.hashCode();
        assertEquals(expectedHashCodeResult, playerResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PlayerResponse#equals(Object)}
     *   <li>{@link PlayerResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setId("42");
        playerResponse.setToken("ABC123");
        playerResponse.setValid(true);

        PlayerResponse playerResponse1 = new PlayerResponse();
        playerResponse1.setId("42");
        playerResponse1.setToken("ABC123");
        playerResponse1.setValid(true);
        assertEquals(playerResponse, playerResponse1);
        int expectedHashCodeResult = playerResponse.hashCode();
        assertEquals(expectedHashCodeResult, playerResponse1.hashCode());
    }

    /**
     * Method under test: {@link PlayerResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setId("ABC123");
        playerResponse.setToken("ABC123");
        playerResponse.setValid(true);

        PlayerResponse playerResponse1 = new PlayerResponse();
        playerResponse1.setId("42");
        playerResponse1.setToken("ABC123");
        playerResponse1.setValid(true);
        assertNotEquals(playerResponse, playerResponse1);
    }

    /**
     * Method under test: {@link PlayerResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setId(null);
        playerResponse.setToken("ABC123");
        playerResponse.setValid(true);

        PlayerResponse playerResponse1 = new PlayerResponse();
        playerResponse1.setId("42");
        playerResponse1.setToken("ABC123");
        playerResponse1.setValid(true);
        assertNotEquals(playerResponse, playerResponse1);
    }

    /**
     * Method under test: {@link PlayerResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setId("42");
        playerResponse.setToken("42");
        playerResponse.setValid(true);

        PlayerResponse playerResponse1 = new PlayerResponse();
        playerResponse1.setId("42");
        playerResponse1.setToken("ABC123");
        playerResponse1.setValid(true);
        assertNotEquals(playerResponse, playerResponse1);
    }

    /**
     * Method under test: {@link PlayerResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setId("42");
        playerResponse.setToken(null);
        playerResponse.setValid(true);

        PlayerResponse playerResponse1 = new PlayerResponse();
        playerResponse1.setId("42");
        playerResponse1.setToken("ABC123");
        playerResponse1.setValid(true);
        assertNotEquals(playerResponse, playerResponse1);
    }

    /**
     * Method under test: {@link PlayerResponse#equals(Object)}
     */
    @Test
    void testEquals9() {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setId("42");
        playerResponse.setToken("ABC123");
        playerResponse.setValid(false);

        PlayerResponse playerResponse1 = new PlayerResponse();
        playerResponse1.setId("42");
        playerResponse1.setToken("ABC123");
        playerResponse1.setValid(true);
        assertNotEquals(playerResponse, playerResponse1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PlayerResponse#equals(Object)}
     *   <li>{@link PlayerResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setId(null);
        playerResponse.setToken("ABC123");
        playerResponse.setValid(true);

        PlayerResponse playerResponse1 = new PlayerResponse();
        playerResponse1.setId(null);
        playerResponse1.setToken("ABC123");
        playerResponse1.setValid(true);
        assertEquals(playerResponse, playerResponse1);
        int expectedHashCodeResult = playerResponse.hashCode();
        assertEquals(expectedHashCodeResult, playerResponse1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PlayerResponse#equals(Object)}
     *   <li>{@link PlayerResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals11() {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setId("42");
        playerResponse.setToken(null);
        playerResponse.setValid(true);

        PlayerResponse playerResponse1 = new PlayerResponse();
        playerResponse1.setId("42");
        playerResponse1.setToken(null);
        playerResponse1.setValid(true);
        assertEquals(playerResponse, playerResponse1);
        int expectedHashCodeResult = playerResponse.hashCode();
        assertEquals(expectedHashCodeResult, playerResponse1.hashCode());
    }
}

