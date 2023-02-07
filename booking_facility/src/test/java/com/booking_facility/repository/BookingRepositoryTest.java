package com.booking_facility.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.booking_facility.entity.GameEnum;
import com.booking_facility.repository.BookingRepository;

class BookingRepositoryTest {
    /**
     * Method under test: {@link BookingRepository#findFirstByGameNameOrderByGroundNumberDesc(GameEnum)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindFirstByGameNameOrderByGroundNumberDesc() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //   See https://diff.blue/R013 to resolve this issue.

        BookingRepository bookingRepository = null;
        bookingRepository.findFirstByGameNameOrderByGroundNumberDesc(GameEnum.CRICKET);
    }

    /**
     * Method under test: {@link BookingRepository#findFirstByGameNameOrderByGroundNumberDesc(GameEnum)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindFirstByGameNameOrderByGroundNumberDesc2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //   See https://diff.blue/R013 to resolve this issue.

        BookingRepository bookingRepository = null;
        bookingRepository.findFirstByGameNameOrderByGroundNumberDesc(GameEnum.FOOTBALL);
    }

    /**
     * Method under test: {@link BookingRepository#findFirstByGameNameOrderByGroundNumberDesc(GameEnum)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindFirstByGameNameOrderByGroundNumberDesc3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //   See https://diff.blue/R013 to resolve this issue.

        BookingRepository bookingRepository = null;
        bookingRepository.findFirstByGameNameOrderByGroundNumberDesc(GameEnum.BADMINTON);
    }

    /**
     * Method under test: {@link BookingRepository#findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc(GameEnum, LocalDate, LocalTime)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "Object.getClass()" because "obj" is null
        //   See https://diff.blue/R013 to resolve this issue.

        BookingRepository bookingRepository = null;
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        bookingRepository.findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc(GameEnum.CRICKET,
                ofEpochDayResult, LocalTime.of(1, 1));
    }

    /**
     * Method under test: {@link BookingRepository#findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc(GameEnum, LocalDate, LocalTime)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "Object.getClass()" because "obj" is null
        //   See https://diff.blue/R013 to resolve this issue.

        BookingRepository bookingRepository = null;
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        bookingRepository.findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc(GameEnum.FOOTBALL,
                ofEpochDayResult, LocalTime.of(1, 1));
    }

    /**
     * Method under test: {@link BookingRepository#findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc(GameEnum, LocalDate, LocalTime)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "Object.getClass()" because "obj" is null
        //   See https://diff.blue/R013 to resolve this issue.

        BookingRepository bookingRepository = null;
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        bookingRepository.findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc(GameEnum.BADMINTON,
                ofEpochDayResult, LocalTime.of(1, 1));
    }
}

