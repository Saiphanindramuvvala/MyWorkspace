package com.booking_facility.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.booking_facility.entity.BookingEntity;
import com.booking_facility.entity.GameEnum;
import com.booking_facility.repository.BookingRepository;
import com.booking_facility.service.BookingService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BookingService.class})
@ExtendWith(SpringExtension.class)
class BookingServiceTest {
    @MockBean
    private BookingRepository bookingRepository;

    @Autowired
    private BookingService bookingService;

    @Test
    void testDoBookingCricket() {
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
        Optional<BookingEntity> ofResult = Optional.of(booking1);
        when(bookingRepository.save((BookingEntity) any())).thenReturn(bookingEntity);
        when(bookingRepository.findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc((GameEnum) any(),
                (LocalDate) any(), (LocalTime) any())).thenReturn(ofResult);

        BookingEntity booking2 = new BookingEntity();
        booking2.setBookingId(123);
        booking2.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking2.setDob(LocalDate.ofEpochDay(1L));
        booking2.setFirst_name("Jane");
        booking2.setGameName(GameEnum.CRICKET);
        booking2.setGroundNumber(10);
        booking2.setLast_name("Doe");
        booking2.setPlayerId("42");
        booking2.setTimeOfGame(LocalTime.of(1, 1));
        assertSame(bookingEntity, bookingService.doBooking(booking2));
        verify(bookingRepository).save((BookingEntity) any());
        verify(bookingRepository).findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc((GameEnum) any(),
                (LocalDate) any(), (LocalTime) any());
        assertEquals(11, booking2.getGroundNumber());
    }

    /**
     * Method under test: {@link BookingService#doBooking(BookingEntity)}
     */
    @Test
    void testDoBookingCricket2() {
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
        BookingEntity booking1 = mock(BookingEntity.class);
        when(booking1.getTimeOfGame()).thenReturn(LocalTime.of(0, 1));
        when(booking1.getDateOfGame()).thenReturn(LocalDate.ofEpochDay(1L));
        doNothing().when(booking1).setBookingId(anyInt());
        doNothing().when(booking1).setDateOfGame((LocalDate) any());
        doNothing().when(booking1).setDob((LocalDate) any());
        doNothing().when(booking1).setFirst_name((String) any());
        doNothing().when(booking1).setGameName((GameEnum) any());
        doNothing().when(booking1).setGroundNumber(anyInt());
        doNothing().when(booking1).setLast_name((String) any());
        doNothing().when(booking1).setPlayerId((String) any());
        doNothing().when(booking1).setTimeOfGame((LocalTime) any());
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        Optional<BookingEntity> ofResult = Optional.of(booking1);
        when(bookingRepository.save((BookingEntity) any())).thenReturn(bookingEntity);
        when(bookingRepository.findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc((GameEnum) any(),
                (LocalDate) any(), (LocalTime) any())).thenReturn(ofResult);

        BookingEntity booking2 = new BookingEntity();
        booking2.setBookingId(123);
        booking2.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking2.setDob(LocalDate.ofEpochDay(1L));
        booking2.setFirst_name("Jane");
        booking2.setGameName(GameEnum.CRICKET);
        booking2.setGroundNumber(10);
        booking2.setLast_name("Doe");
        booking2.setPlayerId("42");
        booking2.setTimeOfGame(LocalTime.of(1, 1));
        assertSame(bookingEntity, bookingService.doBooking(booking2));
        verify(bookingRepository).save((BookingEntity) any());
        verify(bookingRepository).findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc((GameEnum) any(),
                (LocalDate) any(), (LocalTime) any());
        verify(booking1).getDateOfGame();
        verify(booking1).getTimeOfGame();
        verify(booking1).setBookingId(anyInt());
        verify(booking1).setDateOfGame((LocalDate) any());
        verify(booking1).setDob((LocalDate) any());
        verify(booking1).setFirst_name((String) any());
        verify(booking1).setGameName((GameEnum) any());
        verify(booking1).setGroundNumber(anyInt());
        verify(booking1).setLast_name((String) any());
        verify(booking1).setPlayerId((String) any());
        verify(booking1).setTimeOfGame((LocalTime) any());
        assertEquals(1, booking2.getGroundNumber());
    }

    /**
     * Method under test: {@link BookingService#doBooking(BookingEntity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoBookingCricket3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.time.LocalTime.equals(Object)" because the return value of "com.cognizant.booking_facility.entity.Booking.getTimeOfGame()" is null
        //       at com.cognizant.booking_facility.service.BookingService.doBooking(BookingService.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

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
        BookingEntity booking1 = mock(BookingEntity.class);
        when(booking1.getTimeOfGame()).thenReturn(null);
        when(booking1.getDateOfGame()).thenReturn(LocalDate.ofEpochDay(1L));
        doNothing().when(booking1).setBookingId(anyInt());
        doNothing().when(booking1).setDateOfGame((LocalDate) any());
        doNothing().when(booking1).setDob((LocalDate) any());
        doNothing().when(booking1).setFirst_name((String) any());
        doNothing().when(booking1).setGameName((GameEnum) any());
        doNothing().when(booking1).setGroundNumber(anyInt());
        doNothing().when(booking1).setLast_name((String) any());
        doNothing().when(booking1).setPlayerId((String) any());
        doNothing().when(booking1).setTimeOfGame((LocalTime) any());
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        Optional<BookingEntity> ofResult = Optional.of(booking1);
        when(bookingRepository.save((BookingEntity) any())).thenReturn(bookingEntity);
        when(bookingRepository.findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc((GameEnum) any(),
                (LocalDate) any(), (LocalTime) any())).thenReturn(ofResult);

        BookingEntity booking2 = new BookingEntity();
        booking2.setBookingId(123);
        booking2.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking2.setDob(LocalDate.ofEpochDay(1L));
        booking2.setFirst_name("Jane");
        booking2.setGameName(GameEnum.CRICKET);
        booking2.setGroundNumber(10);
        booking2.setLast_name("Doe");
        booking2.setPlayerId("42");
        booking2.setTimeOfGame(LocalTime.of(1, 1));
        bookingService.doBooking(booking2);
    }

    /**
     * Method under test: {@link BookingService#doBooking(BookingEntity)}
     */
    @Test
    void testDoBookingCricket4() {
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
        BookingEntity booking1 = mock(BookingEntity.class);
        when(booking1.getTimeOfGame()).thenReturn(LocalTime.of(1, 1));
        when(booking1.getDateOfGame()).thenReturn(LocalDate.ofEpochDay(-1L));
        doNothing().when(booking1).setBookingId(anyInt());
        doNothing().when(booking1).setDateOfGame((LocalDate) any());
        doNothing().when(booking1).setDob((LocalDate) any());
        doNothing().when(booking1).setFirst_name((String) any());
        doNothing().when(booking1).setGameName((GameEnum) any());
        doNothing().when(booking1).setGroundNumber(anyInt());
        doNothing().when(booking1).setLast_name((String) any());
        doNothing().when(booking1).setPlayerId((String) any());
        doNothing().when(booking1).setTimeOfGame((LocalTime) any());
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        Optional<BookingEntity> ofResult = Optional.of(booking1);
        when(bookingRepository.save((BookingEntity) any())).thenReturn(bookingEntity);
        when(bookingRepository.findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc((GameEnum) any(),
                (LocalDate) any(), (LocalTime) any())).thenReturn(ofResult);

        BookingEntity booking2 = new BookingEntity();
        booking2.setBookingId(123);
        booking2.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking2.setDob(LocalDate.ofEpochDay(1L));
        booking2.setFirst_name("Jane");
        booking2.setGameName(GameEnum.CRICKET);
        booking2.setGroundNumber(10);
        booking2.setLast_name("Doe");
        booking2.setPlayerId("42");
        booking2.setTimeOfGame(LocalTime.of(1, 1));
        assertSame(bookingEntity, bookingService.doBooking(booking2));
        verify(bookingRepository).save((BookingEntity) any());
        verify(bookingRepository).findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc((GameEnum) any(),
                (LocalDate) any(), (LocalTime) any());
        verify(booking1).getDateOfGame();
        verify(booking1).setBookingId(anyInt());
        verify(booking1).setDateOfGame((LocalDate) any());
        verify(booking1).setDob((LocalDate) any());
        verify(booking1).setFirst_name((String) any());
        verify(booking1).setGameName((GameEnum) any());
        verify(booking1).setGroundNumber(anyInt());
        verify(booking1).setLast_name((String) any());
        verify(booking1).setPlayerId((String) any());
        verify(booking1).setTimeOfGame((LocalTime) any());
        assertEquals(1, booking2.getGroundNumber());
    }

    /**
     * Method under test: {@link BookingService#doBooking(BookingEntity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoBookingCricket5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.time.LocalDate.isEqual(java.time.chrono.ChronoLocalDate)" because the return value of "com.cognizant.booking_facility.entity.Booking.getDateOfGame()" is null
        //       at com.cognizant.booking_facility.service.BookingService.doBooking(BookingService.java:28)
        //   See https://diff.blue/R013 to resolve this issue.

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
        BookingEntity booking1 = mock(BookingEntity.class);
        when(booking1.getTimeOfGame()).thenReturn(LocalTime.of(1, 1));
        when(booking1.getDateOfGame()).thenReturn(null);
        doNothing().when(booking1).setBookingId(anyInt());
        doNothing().when(booking1).setDateOfGame((LocalDate) any());
        doNothing().when(booking1).setDob((LocalDate) any());
        doNothing().when(booking1).setFirst_name((String) any());
        doNothing().when(booking1).setGameName((GameEnum) any());
        doNothing().when(booking1).setGroundNumber(anyInt());
        doNothing().when(booking1).setLast_name((String) any());
        doNothing().when(booking1).setPlayerId((String) any());
        doNothing().when(booking1).setTimeOfGame((LocalTime) any());
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));
        Optional<BookingEntity> ofResult = Optional.of(booking1);
        when(bookingRepository.save((BookingEntity) any())).thenReturn(bookingEntity);
        when(bookingRepository.findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc((GameEnum) any(),
                (LocalDate) any(), (LocalTime) any())).thenReturn(ofResult);

        BookingEntity booking2 = new BookingEntity();
        booking2.setBookingId(123);
        booking2.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking2.setDob(LocalDate.ofEpochDay(1L));
        booking2.setFirst_name("Jane");
        booking2.setGameName(GameEnum.CRICKET);
        booking2.setGroundNumber(10);
        booking2.setLast_name("Doe");
        booking2.setPlayerId("42");
        booking2.setTimeOfGame(LocalTime.of(1, 1));
        bookingService.doBooking(booking2);
    }

    /**
     * Method under test: {@link BookingService#doBooking(BookingEntity)}
     */
    @Test
    void testDoBookingCricket6() {
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
        when(bookingRepository.save((BookingEntity) any())).thenReturn(bookingEntity);
        when(bookingRepository.findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc((GameEnum) any(),
                (LocalDate) any(), (LocalTime) any())).thenReturn(Optional.empty());
        BookingEntity booking1 = mock(BookingEntity.class);
        when(booking1.getTimeOfGame()).thenReturn(LocalTime.of(1, 1));
        when(booking1.getDateOfGame()).thenReturn(LocalDate.ofEpochDay(1L));
        doNothing().when(booking1).setBookingId(anyInt());
        doNothing().when(booking1).setDateOfGame((LocalDate) any());
        doNothing().when(booking1).setDob((LocalDate) any());
        doNothing().when(booking1).setFirst_name((String) any());
        doNothing().when(booking1).setGameName((GameEnum) any());
        doNothing().when(booking1).setGroundNumber(anyInt());
        doNothing().when(booking1).setLast_name((String) any());
        doNothing().when(booking1).setPlayerId((String) any());
        doNothing().when(booking1).setTimeOfGame((LocalTime) any());
        booking1.setBookingId(123);
        booking1.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking1.setDob(LocalDate.ofEpochDay(1L));
        booking1.setFirst_name("Jane");
        booking1.setGameName(GameEnum.CRICKET);
        booking1.setGroundNumber(10);
        booking1.setLast_name("Doe");
        booking1.setPlayerId("42");
        booking1.setTimeOfGame(LocalTime.of(1, 1));

        BookingEntity booking2 = new BookingEntity();
        booking2.setBookingId(123);
        booking2.setDateOfGame(LocalDate.ofEpochDay(1L));
        booking2.setDob(LocalDate.ofEpochDay(1L));
        booking2.setFirst_name("Jane");
        booking2.setGameName(GameEnum.CRICKET);
        booking2.setGroundNumber(10);
        booking2.setLast_name("Doe");
        booking2.setPlayerId("42");
        booking2.setTimeOfGame(LocalTime.of(1, 1));
        assertSame(bookingEntity, bookingService.doBooking(booking2));
        verify(bookingRepository).save((BookingEntity) any());
        verify(bookingRepository).findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc((GameEnum) any(),
                (LocalDate) any(), (LocalTime) any());
        verify(booking1).setBookingId(anyInt());
        verify(booking1).setDateOfGame((LocalDate) any());
        verify(booking1).setDob((LocalDate) any());
        verify(booking1).setFirst_name((String) any());
        verify(booking1).setGameName((GameEnum) any());
        verify(booking1).setGroundNumber(anyInt());
        verify(booking1).setLast_name((String) any());
        verify(booking1).setPlayerId((String) any());
        verify(booking1).setTimeOfGame((LocalTime) any());
        assertEquals(1, booking2.getGroundNumber());
    }
    
    @Test
    void testDoBookingCricket7() {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.now());
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(9, 0));
        BookingEntity booking1 = mock(BookingEntity.class);
        when(booking1.getTimeOfGame()).thenReturn(LocalTime.of(9, 0));
        when(booking1.getDateOfGame()).thenReturn(LocalDate.now());
        doNothing().when(booking1).setBookingId(anyInt());
        doNothing().when(booking1).setDateOfGame((LocalDate) any());
        doNothing().when(booking1).setDob((LocalDate) any());
        doNothing().when(booking1).setFirst_name((String) any());
        doNothing().when(booking1).setGameName((GameEnum) any());
        doNothing().when(booking1).setGroundNumber(anyInt());
        doNothing().when(booking1).setLast_name((String) any());
        doNothing().when(booking1).setPlayerId((String) any());
        doNothing().when(booking1).setTimeOfGame((LocalTime) any());
    }
}

