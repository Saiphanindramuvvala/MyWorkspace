package com.booking_facility.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.booking_facility.entity.BookingEntity;
import com.booking_facility.entity.GameEnum;

class BookingTest {
    /**
     * Method under test: {@link BookingEntity#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new BookingEntity()).canEqual("Other"));
    }

    /**
     * Method under test: {@link BookingEntity#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        BookingEntity bookingEntity = new BookingEntity();

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(3L));
        booking1.setDob(LocalDate.ofEpochDay(3L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(3, 1));
        assertTrue(bookingEntity.canEqual(booking1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link BookingEntity}
     *   <li>{@link BookingEntity#setBookingId(int)}
     *   <li>{@link BookingEntity#setDateOfGame(LocalDate)}
     *   <li>{@link BookingEntity#setDob(LocalDate)}
     *   <li>{@link BookingEntity#setFirst_name(String)}
     *   <li>{@link BookingEntity#setGameName(GameEnum)}
     *   <li>{@link BookingEntity#setGroundNumber(int)}
     *   <li>{@link BookingEntity#setLast_name(String)}
     *   <li>{@link BookingEntity#setPlayerId(String)}
     *   <li>{@link BookingEntity#setTimeOfGame(LocalTime)}
     *   <li>{@link BookingEntity#toString()}
     *   <li>{@link BookingEntity#getBookingId()}
     *   <li>{@link BookingEntity#getDateOfGame()}
     *   <li>{@link BookingEntity#getDob()}
     *   <li>{@link BookingEntity#getFirst_name()}
     *   <li>{@link BookingEntity#getGameName()}
     *   <li>{@link BookingEntity#getGroundNumber()}
     *   <li>{@link BookingEntity#getLast_name()}
     *   <li>{@link BookingEntity#getPlayerId()}
     *   <li>{@link BookingEntity#getTimeOfGame()}
     * </ul>
     */
    @Test
    void testConstructor() {
        BookingEntity actualBooking = new BookingEntity();
        actualBooking.setBookingId(123);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualBooking.setDateOfGame(ofEpochDayResult);
        LocalDate ofEpochDayResult1 = LocalDate.ofEpochDay(1L);
        actualBooking.setDob(ofEpochDayResult1);
        actualBooking.setFirst_name("Jane");
        actualBooking.setGameName(GameEnum.CRICKET);
        actualBooking.setGroundNumber(10);
        actualBooking.setLast_name("Doe");
        actualBooking.setPlayerId("42");
        LocalTime ofResult = LocalTime.of(1, 1);
        actualBooking.setTimeOfGame(ofResult);
        String actualToStringResult = actualBooking.toString();
        assertEquals(123, actualBooking.getBookingId());
        assertSame(ofEpochDayResult, actualBooking.getDateOfGame());
        assertSame(ofEpochDayResult1, actualBooking.getDob());
        assertEquals("Jane", actualBooking.getFirst_name());
        assertEquals(GameEnum.CRICKET, actualBooking.getGameName());
        assertEquals(10, actualBooking.getGroundNumber());
        assertEquals("Doe", actualBooking.getLast_name());
        assertEquals("42", actualBooking.getPlayerId());
        assertSame(ofResult, actualBooking.getTimeOfGame());
        assertEquals(
                "Booking(bookingId=123, playerId=42, first_name=Jane, last_name=Doe, dob=1970-01-02, dateOfGame=1970-01-02,"
                        + " timeOfGame=01:01, groundNumber=10, gameName=CRICKET)",
                actualToStringResult);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, null);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals2() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, "Different type to Booking");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link BookingEntity#equals(Object)}
     *   <li>{@link BookingEntity#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));
        assertEquals(bookingEntity, bookingEntity);
        int expectedHashCodeResult = bookingEntity.hashCode();
        assertEquals(expectedHashCodeResult, bookingEntity.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link BookingEntity#equals(Object)}
     *   <li>{@link BookingEntity#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertEquals(bookingEntity, booking1);
        int expectedHashCodeResult = bookingEntity.hashCode();
        assertEquals(expectedHashCodeResult, booking1.hashCode());
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals5() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(1);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, booking1);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals6() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(3L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, booking1);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals7() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(null);
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, booking1);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals8() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(3L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, booking1);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals9() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(null);
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, booking1);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals10() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("42");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, booking1);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals11() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name(null);
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, booking1);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals12() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(null);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, booking1);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals13() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.FOOTBALL);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, booking1);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals14() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(1);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, booking1);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals15() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("42");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, booking1);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals16() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name(null);
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, booking1);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals17() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("Jane");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, booking1);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals18() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId(null);
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, booking1);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals19() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(3, 1));

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, booking1);
    }

    /**
     * Method under test: {@link BookingEntity#equals(Object)}
     */
    @Test
    void testEquals20() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(null);

        BookingEntity booking1 = new BookingEntity();
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingEntity, booking1);
    }
}

