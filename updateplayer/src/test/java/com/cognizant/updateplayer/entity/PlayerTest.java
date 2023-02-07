package com.cognizant.updateplayer.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class PlayerTest {
    /**
     * Method under test: {@link Player#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Player()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Player#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Player player = new Player();

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(3);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(3, 3, 3, 3, 1));
        player1.setDob(LocalDate.ofEpochDay(3L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertTrue(player.canEqual(player1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Player}
     *   <li>{@link Player#setAddress(String)}
     *   <li>{@link Player#setAge(int)}
     *   <li>{@link Player#setCountry(String)}
     *   <li>{@link Player#setCreationdate(LocalDateTime)}
     *   <li>{@link Player#setDob(LocalDate)}
     *   <li>{@link Player#setEmail(String)}
     *   <li>{@link Player#setFname(String)}
     *   <li>{@link Player#setId(String)}
     *   <li>{@link Player#setLname(String)}
     *   <li>{@link Player#setMobile(String)}
     *   <li>{@link Player#setPan(String)}
     *   <li>{@link Player#setPassword(String)}
     *   <li>{@link Player#setState(String)}
     *   <li>{@link Player#toString()}
     *   <li>{@link Player#getAddress()}
     *   <li>{@link Player#getAge()}
     *   <li>{@link Player#getCountry()}
     *   <li>{@link Player#getCreationdate()}
     *   <li>{@link Player#getDob()}
     *   <li>{@link Player#getEmail()}
     *   <li>{@link Player#getFname()}
     *   <li>{@link Player#getId()}
     *   <li>{@link Player#getLname()}
     *   <li>{@link Player#getMobile()}
     *   <li>{@link Player#getPan()}
     *   <li>{@link Player#getPassword()}
     *   <li>{@link Player#getState()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Player actualPlayer = new Player();
        actualPlayer.setAddress("42 Main St");
        actualPlayer.setAge(1);
        actualPlayer.setCountry("GB");
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        actualPlayer.setCreationdate(ofResult);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualPlayer.setDob(ofEpochDayResult);
        actualPlayer.setEmail("jane.doe@example.org");
        actualPlayer.setFname("Fname");
        actualPlayer.setId("42");
        actualPlayer.setLname("Lname");
        actualPlayer.setMobile("Mobile");
        actualPlayer.setPan("Pan");
        actualPlayer.setPassword("iloveyou");
        actualPlayer.setState("MD");
        String actualToStringResult = actualPlayer.toString();
        assertEquals("42 Main St", actualPlayer.getAddress());
        assertEquals(1, actualPlayer.getAge());
        assertEquals("GB", actualPlayer.getCountry());
        assertSame(ofResult, actualPlayer.getCreationdate());
        assertSame(ofEpochDayResult, actualPlayer.getDob());
        assertEquals("jane.doe@example.org", actualPlayer.getEmail());
        assertEquals("Fname", actualPlayer.getFname());
        assertEquals("42", actualPlayer.getId());
        assertEquals("Lname", actualPlayer.getLname());
        assertEquals("Mobile", actualPlayer.getMobile());
        assertEquals("Pan", actualPlayer.getPan());
        assertEquals("iloveyou", actualPlayer.getPassword());
        assertEquals("MD", actualPlayer.getState());
        assertEquals(
                "Player(id=42, fname=Fname, lname=Lname, email=jane.doe@example.org, age=1, dob=1970-01-02, mobile=Mobile,"
                        + " address=42 Main St, state=MD, country=GB, pan=Pan, creationdate=0001-01-01T01:01, password=iloveyou"
                        + ")",
                actualToStringResult);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");
        assertNotEquals(player, null);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals2() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");
        assertNotEquals(player, "Different type to Player");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Player#equals(Object)}
     *   <li>{@link Player#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");
        assertEquals(player, player);
        int expectedHashCodeResult = player.hashCode();
        assertEquals(expectedHashCodeResult, player.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Player#equals(Object)}
     *   <li>{@link Player#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertEquals(player, player1);
        int expectedHashCodeResult = player.hashCode();
        assertEquals(expectedHashCodeResult, player1.hashCode());
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals5() {
        Player player = new Player();
        player.setAddress("42");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals6() {
        Player player = new Player();
        player.setAddress(null);
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals7() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(3);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals8() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GBR");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals9() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry(null);
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals10() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(3, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals11() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(null);
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals12() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(3L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals13() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(null);
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals14() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("42");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals15() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail(null);
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals16() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("42");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals17() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname(null);
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals18() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("Fname");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals19() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId(null);
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals20() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("42");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals21() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname(null);
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals22() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("42");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals23() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile(null);
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals24() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("42");
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals25() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan(null);
        player.setPassword("iloveyou");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals26() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("42");
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals27() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword(null);
        player.setState("MD");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals28() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("42");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }

    /**
     * Method under test: {@link Player#equals(Object)}
     */
    @Test
    void testEquals29() {
        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState(null);

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertNotEquals(player, player1);
    }
}

