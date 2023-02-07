package com.booking_facility.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.booking_facility.vo.BookingResponse;

class BookingResponseTest {
    /**
     * Method under test: {@link BookingResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new BookingResponse()).canEqual("Other"));
    }

    /**
     * Method under test: {@link BookingResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        BookingResponse bookingResponse = new BookingResponse();

        BookingResponse bookingResponse1 = new BookingResponse();
        bookingResponse1.setBookingId(123);
        bookingResponse1.setDateOfGame(LocalDate.ofEpochDay(3L));
        bookingResponse1.setGameName("Game Name");
        bookingResponse1.setGroundNumber(10);
        bookingResponse1.setPlayerId("42");
        bookingResponse1.setResponse("Response");
        bookingResponse1.setTimeOfGame(LocalTime.of(3, 1));
        assertTrue(bookingResponse.canEqual(bookingResponse1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link BookingResponse}
     *   <li>{@link BookingResponse#setBookingId(int)}
     *   <li>{@link BookingResponse#setDateOfGame(LocalDate)}
     *   <li>{@link BookingResponse#setGameName(String)}
     *   <li>{@link BookingResponse#setGroundNumber(int)}
     *   <li>{@link BookingResponse#setPlayerId(String)}
     *   <li>{@link BookingResponse#setResponse(String)}
     *   <li>{@link BookingResponse#setTimeOfGame(LocalTime)}
     *   <li>{@link BookingResponse#toString()}
     *   <li>{@link BookingResponse#getBookingId()}
     *   <li>{@link BookingResponse#getDateOfGame()}
     *   <li>{@link BookingResponse#getGameName()}
     *   <li>{@link BookingResponse#getGroundNumber()}
     *   <li>{@link BookingResponse#getPlayerId()}
     *   <li>{@link BookingResponse#getResponse()}
     *   <li>{@link BookingResponse#getTimeOfGame()}
     * </ul>
     */
    @Test
    void testConstructor() {
        BookingResponse actualBookingResponse = new BookingResponse();
        actualBookingResponse.setBookingId(123);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualBookingResponse.setDateOfGame(ofEpochDayResult);
        actualBookingResponse.setGameName("Game Name");
        actualBookingResponse.setGroundNumber(10);
        actualBookingResponse.setPlayerId("42");
        actualBookingResponse.setResponse("Response");
        LocalTime ofResult = LocalTime.of(1, 1);
        actualBookingResponse.setTimeOfGame(ofResult);
        String actualToStringResult = actualBookingResponse.toString();
        assertEquals(123, actualBookingResponse.getBookingId());
        assertSame(ofEpochDayResult, actualBookingResponse.getDateOfGame());
        assertEquals("Game Name", actualBookingResponse.getGameName());
        assertEquals(10, actualBookingResponse.getGroundNumber());
        assertEquals("42", actualBookingResponse.getPlayerId());
        assertEquals("Response", actualBookingResponse.getResponse());
        assertSame(ofResult, actualBookingResponse.getTimeOfGame());
        assertEquals("BookingResponse(response=Response, bookingId=123, playerId=42, groundNumber=10, gameName=Game Name,"
                + " timeOfGame=01:01, dateOfGame=1970-01-02)", actualToStringResult);
    }

    /**
     * Method under test: {@link BookingResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse.setGameName("Game Name");
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId("42");
        bookingResponse.setResponse("Response");
        bookingResponse.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingResponse, null);
    }

    /**
     * Method under test: {@link BookingResponse#equals(Object)}
     */
    @Test
    void testEquals2() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse.setGameName("Game Name");
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId("42");
        bookingResponse.setResponse("Response");
        bookingResponse.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingResponse, "Different type to BookingResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link BookingResponse#equals(Object)}
     *   <li>{@link BookingResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse.setGameName("Game Name");
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId("42");
        bookingResponse.setResponse("Response");
        bookingResponse.setTimeOfGame(LocalTime.of(1, 1));
        assertEquals(bookingResponse, bookingResponse);
        int expectedHashCodeResult = bookingResponse.hashCode();
        assertEquals(expectedHashCodeResult, bookingResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link BookingResponse#equals(Object)}
     *   <li>{@link BookingResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse.setGameName("Game Name");
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId("42");
        bookingResponse.setResponse("Response");
        bookingResponse.setTimeOfGame(LocalTime.of(1, 1));

        BookingResponse bookingResponse1 = new BookingResponse();
        bookingResponse1.setBookingId(123);
        bookingResponse1.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse1.setGameName("Game Name");
        bookingResponse1.setGroundNumber(10);
        bookingResponse1.setPlayerId("42");
        bookingResponse1.setResponse("Response");
        bookingResponse1.setTimeOfGame(LocalTime.of(1, 1));
        assertEquals(bookingResponse, bookingResponse1);
        int expectedHashCodeResult = bookingResponse.hashCode();
        assertEquals(expectedHashCodeResult, bookingResponse1.hashCode());
    }

    /**
     * Method under test: {@link BookingResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(1);
        bookingResponse.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse.setGameName("Game Name");
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId("42");
        bookingResponse.setResponse("Response");
        bookingResponse.setTimeOfGame(LocalTime.of(1, 1));

        BookingResponse bookingResponse1 = new BookingResponse();
        bookingResponse1.setBookingId(123);
        bookingResponse1.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse1.setGameName("Game Name");
        bookingResponse1.setGroundNumber(10);
        bookingResponse1.setPlayerId("42");
        bookingResponse1.setResponse("Response");
        bookingResponse1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingResponse, bookingResponse1);
    }

    /**
     * Method under test: {@link BookingResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(LocalDate.ofEpochDay(3L));
        bookingResponse.setGameName("Game Name");
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId("42");
        bookingResponse.setResponse("Response");
        bookingResponse.setTimeOfGame(LocalTime.of(1, 1));

        BookingResponse bookingResponse1 = new BookingResponse();
        bookingResponse1.setBookingId(123);
        bookingResponse1.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse1.setGameName("Game Name");
        bookingResponse1.setGroundNumber(10);
        bookingResponse1.setPlayerId("42");
        bookingResponse1.setResponse("Response");
        bookingResponse1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingResponse, bookingResponse1);
    }

    /**
     * Method under test: {@link BookingResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(null);
        bookingResponse.setGameName("Game Name");
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId("42");
        bookingResponse.setResponse("Response");
        bookingResponse.setTimeOfGame(LocalTime.of(1, 1));

        BookingResponse bookingResponse1 = new BookingResponse();
        bookingResponse1.setBookingId(123);
        bookingResponse1.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse1.setGameName("Game Name");
        bookingResponse1.setGroundNumber(10);
        bookingResponse1.setPlayerId("42");
        bookingResponse1.setResponse("Response");
        bookingResponse1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingResponse, bookingResponse1);
    }

    /**
     * Method under test: {@link BookingResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse.setGameName("Response");
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId("42");
        bookingResponse.setResponse("Response");
        bookingResponse.setTimeOfGame(LocalTime.of(1, 1));

        BookingResponse bookingResponse1 = new BookingResponse();
        bookingResponse1.setBookingId(123);
        bookingResponse1.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse1.setGameName("Game Name");
        bookingResponse1.setGroundNumber(10);
        bookingResponse1.setPlayerId("42");
        bookingResponse1.setResponse("Response");
        bookingResponse1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingResponse, bookingResponse1);
    }

    /**
     * Method under test: {@link BookingResponse#equals(Object)}
     */
    @Test
    void testEquals9() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse.setGameName(null);
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId("42");
        bookingResponse.setResponse("Response");
        bookingResponse.setTimeOfGame(LocalTime.of(1, 1));

        BookingResponse bookingResponse1 = new BookingResponse();
        bookingResponse1.setBookingId(123);
        bookingResponse1.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse1.setGameName("Game Name");
        bookingResponse1.setGroundNumber(10);
        bookingResponse1.setPlayerId("42");
        bookingResponse1.setResponse("Response");
        bookingResponse1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingResponse, bookingResponse1);
    }

    /**
     * Method under test: {@link BookingResponse#equals(Object)}
     */
    @Test
    void testEquals10() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse.setGameName("Game Name");
        bookingResponse.setGroundNumber(1);
        bookingResponse.setPlayerId("42");
        bookingResponse.setResponse("Response");
        bookingResponse.setTimeOfGame(LocalTime.of(1, 1));

        BookingResponse bookingResponse1 = new BookingResponse();
        bookingResponse1.setBookingId(123);
        bookingResponse1.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse1.setGameName("Game Name");
        bookingResponse1.setGroundNumber(10);
        bookingResponse1.setPlayerId("42");
        bookingResponse1.setResponse("Response");
        bookingResponse1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingResponse, bookingResponse1);
    }

    /**
     * Method under test: {@link BookingResponse#equals(Object)}
     */
    @Test
    void testEquals11() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse.setGameName("Game Name");
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId("Response");
        bookingResponse.setResponse("Response");
        bookingResponse.setTimeOfGame(LocalTime.of(1, 1));

        BookingResponse bookingResponse1 = new BookingResponse();
        bookingResponse1.setBookingId(123);
        bookingResponse1.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse1.setGameName("Game Name");
        bookingResponse1.setGroundNumber(10);
        bookingResponse1.setPlayerId("42");
        bookingResponse1.setResponse("Response");
        bookingResponse1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingResponse, bookingResponse1);
    }

    /**
     * Method under test: {@link BookingResponse#equals(Object)}
     */
    @Test
    void testEquals12() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse.setGameName("Game Name");
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId(null);
        bookingResponse.setResponse("Response");
        bookingResponse.setTimeOfGame(LocalTime.of(1, 1));

        BookingResponse bookingResponse1 = new BookingResponse();
        bookingResponse1.setBookingId(123);
        bookingResponse1.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse1.setGameName("Game Name");
        bookingResponse1.setGroundNumber(10);
        bookingResponse1.setPlayerId("42");
        bookingResponse1.setResponse("Response");
        bookingResponse1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingResponse, bookingResponse1);
    }

    /**
     * Method under test: {@link BookingResponse#equals(Object)}
     */
    @Test
    void testEquals13() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse.setGameName("Game Name");
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId("42");
        bookingResponse.setResponse("42");
        bookingResponse.setTimeOfGame(LocalTime.of(1, 1));

        BookingResponse bookingResponse1 = new BookingResponse();
        bookingResponse1.setBookingId(123);
        bookingResponse1.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse1.setGameName("Game Name");
        bookingResponse1.setGroundNumber(10);
        bookingResponse1.setPlayerId("42");
        bookingResponse1.setResponse("Response");
        bookingResponse1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingResponse, bookingResponse1);
    }

    /**
     * Method under test: {@link BookingResponse#equals(Object)}
     */
    @Test
    void testEquals14() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse.setGameName("Game Name");
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId("42");
        bookingResponse.setResponse(null);
        bookingResponse.setTimeOfGame(LocalTime.of(1, 1));

        BookingResponse bookingResponse1 = new BookingResponse();
        bookingResponse1.setBookingId(123);
        bookingResponse1.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse1.setGameName("Game Name");
        bookingResponse1.setGroundNumber(10);
        bookingResponse1.setPlayerId("42");
        bookingResponse1.setResponse("Response");
        bookingResponse1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingResponse, bookingResponse1);
    }

    /**
     * Method under test: {@link BookingResponse#equals(Object)}
     */
    @Test
    void testEquals15() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse.setGameName("Game Name");
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId("42");
        bookingResponse.setResponse("Response");
        bookingResponse.setTimeOfGame(LocalTime.of(3, 1));

        BookingResponse bookingResponse1 = new BookingResponse();
        bookingResponse1.setBookingId(123);
        bookingResponse1.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse1.setGameName("Game Name");
        bookingResponse1.setGroundNumber(10);
        bookingResponse1.setPlayerId("42");
        bookingResponse1.setResponse("Response");
        bookingResponse1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingResponse, bookingResponse1);
    }

    /**
     * Method under test: {@link BookingResponse#equals(Object)}
     */
    @Test
    void testEquals16() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse.setGameName("Game Name");
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId("42");
        bookingResponse.setResponse("Response");
        bookingResponse.setTimeOfGame(null);

        BookingResponse bookingResponse1 = new BookingResponse();
        bookingResponse1.setBookingId(123);
        bookingResponse1.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse1.setGameName("Game Name");
        bookingResponse1.setGroundNumber(10);
        bookingResponse1.setPlayerId("42");
        bookingResponse1.setResponse("Response");
        bookingResponse1.setTimeOfGame(LocalTime.of(1, 1));
        assertNotEquals(bookingResponse, bookingResponse1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link BookingResponse#equals(Object)}
     *   <li>{@link BookingResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals17() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(null);
        bookingResponse.setGameName("Game Name");
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId("42");
        bookingResponse.setResponse("Response");
        bookingResponse.setTimeOfGame(LocalTime.of(1, 1));

        BookingResponse bookingResponse1 = new BookingResponse();
        bookingResponse1.setBookingId(123);
        bookingResponse1.setDateOfGame(null);
        bookingResponse1.setGameName("Game Name");
        bookingResponse1.setGroundNumber(10);
        bookingResponse1.setPlayerId("42");
        bookingResponse1.setResponse("Response");
        bookingResponse1.setTimeOfGame(LocalTime.of(1, 1));
        assertEquals(bookingResponse, bookingResponse1);
        int expectedHashCodeResult = bookingResponse.hashCode();
        assertEquals(expectedHashCodeResult, bookingResponse1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link BookingResponse#equals(Object)}
     *   <li>{@link BookingResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals18() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(123);
        bookingResponse.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse.setGameName(null);
        bookingResponse.setGroundNumber(10);
        bookingResponse.setPlayerId("42");
        bookingResponse.setResponse("Response");
        bookingResponse.setTimeOfGame(LocalTime.of(1, 1));

        BookingResponse bookingResponse1 = new BookingResponse();
        bookingResponse1.setBookingId(123);
        bookingResponse1.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingResponse1.setGameName(null);
        bookingResponse1.setGroundNumber(10);
        bookingResponse1.setPlayerId("42");
        bookingResponse1.setResponse("Response");
        bookingResponse1.setTimeOfGame(LocalTime.of(1, 1));
        assertEquals(bookingResponse, bookingResponse1);
        int expectedHashCodeResult = bookingResponse.hashCode();
        assertEquals(expectedHashCodeResult, bookingResponse1.hashCode());
    }
}

