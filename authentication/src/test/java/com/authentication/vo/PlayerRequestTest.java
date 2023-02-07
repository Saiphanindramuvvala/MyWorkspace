package com.authentication.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PlayerRequestTest {
    /**
     * Method under test: {@link PlayerRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new PlayerRequest()).canEqual("Other"));
    }

    /**
     * Method under test: {@link PlayerRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        PlayerRequest playerRequest = new PlayerRequest();

        PlayerRequest playerRequest1 = new PlayerRequest();
        playerRequest1.setPassword("iloveyou");
        playerRequest1.setUsername("janedoe");
        assertTrue(playerRequest.canEqual(playerRequest1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link PlayerRequest}
     *   <li>{@link PlayerRequest#setPassword(String)}
     *   <li>{@link PlayerRequest#setUsername(String)}
     *   <li>{@link PlayerRequest#toString()}
     *   <li>{@link PlayerRequest#getPassword()}
     *   <li>{@link PlayerRequest#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        PlayerRequest actualPlayerRequest = new PlayerRequest();
        actualPlayerRequest.setPassword("iloveyou");
        actualPlayerRequest.setUsername("janedoe");
        String actualToStringResult = actualPlayerRequest.toString();
        assertEquals("iloveyou", actualPlayerRequest.getPassword());
        assertEquals("janedoe", actualPlayerRequest.getUsername());
        assertEquals("PlayerRequest(username=janedoe, password=iloveyou)", actualToStringResult);
    }

    /**
     * Method under test: {@link PlayerRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setPassword("iloveyou");
        playerRequest.setUsername("janedoe");
        assertNotEquals(playerRequest, null);
    }

    /**
     * Method under test: {@link PlayerRequest#equals(Object)}
     */
    @Test
    void testEquals2() {
        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setPassword("iloveyou");
        playerRequest.setUsername("janedoe");
        assertNotEquals(playerRequest, "Different type to PlayerRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PlayerRequest#equals(Object)}
     *   <li>{@link PlayerRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setPassword("iloveyou");
        playerRequest.setUsername("janedoe");
        assertEquals(playerRequest, playerRequest);
        int expectedHashCodeResult = playerRequest.hashCode();
        assertEquals(expectedHashCodeResult, playerRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PlayerRequest#equals(Object)}
     *   <li>{@link PlayerRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setPassword("iloveyou");
        playerRequest.setUsername("janedoe");

        PlayerRequest playerRequest1 = new PlayerRequest();
        playerRequest1.setPassword("iloveyou");
        playerRequest1.setUsername("janedoe");
        assertEquals(playerRequest, playerRequest1);
        int expectedHashCodeResult = playerRequest.hashCode();
        assertEquals(expectedHashCodeResult, playerRequest1.hashCode());
    }

    /**
     * Method under test: {@link PlayerRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setPassword("janedoe");
        playerRequest.setUsername("janedoe");

        PlayerRequest playerRequest1 = new PlayerRequest();
        playerRequest1.setPassword("iloveyou");
        playerRequest1.setUsername("janedoe");
        assertNotEquals(playerRequest, playerRequest1);
    }

    /**
     * Method under test: {@link PlayerRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setPassword(null);
        playerRequest.setUsername("janedoe");

        PlayerRequest playerRequest1 = new PlayerRequest();
        playerRequest1.setPassword("iloveyou");
        playerRequest1.setUsername("janedoe");
        assertNotEquals(playerRequest, playerRequest1);
    }

    /**
     * Method under test: {@link PlayerRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setPassword("iloveyou");
        playerRequest.setUsername("iloveyou");

        PlayerRequest playerRequest1 = new PlayerRequest();
        playerRequest1.setPassword("iloveyou");
        playerRequest1.setUsername("janedoe");
        assertNotEquals(playerRequest, playerRequest1);
    }

    /**
     * Method under test: {@link PlayerRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setPassword("iloveyou");
        playerRequest.setUsername(null);

        PlayerRequest playerRequest1 = new PlayerRequest();
        playerRequest1.setPassword("iloveyou");
        playerRequest1.setUsername("janedoe");
        assertNotEquals(playerRequest, playerRequest1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PlayerRequest#equals(Object)}
     *   <li>{@link PlayerRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setPassword(null);
        playerRequest.setUsername("janedoe");

        PlayerRequest playerRequest1 = new PlayerRequest();
        playerRequest1.setPassword(null);
        playerRequest1.setUsername("janedoe");
        assertEquals(playerRequest, playerRequest1);
        int expectedHashCodeResult = playerRequest.hashCode();
        assertEquals(expectedHashCodeResult, playerRequest1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PlayerRequest#equals(Object)}
     *   <li>{@link PlayerRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setPassword("iloveyou");
        playerRequest.setUsername(null);

        PlayerRequest playerRequest1 = new PlayerRequest();
        playerRequest1.setPassword("iloveyou");
        playerRequest1.setUsername(null);
        assertEquals(playerRequest, playerRequest1);
        int expectedHashCodeResult = playerRequest.hashCode();
        assertEquals(expectedHashCodeResult, playerRequest1.hashCode());
    }
}

