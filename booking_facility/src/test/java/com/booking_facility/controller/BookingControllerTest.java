package com.booking_facility.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.booking_facility.controller.BookingController;
import com.booking_facility.entity.BookingEntity;
import com.booking_facility.entity.GameEnum;
import com.booking_facility.feign.RegistrationFeign;
import com.booking_facility.service.BookingService;
import com.booking_facility.service.SlotService;
import com.booking_facility.vo.PlayerResponse;

@ContextConfiguration(classes = {BookingController.class})
@ExtendWith(SpringExtension.class)
class BookingControllerTest {
    @Autowired
    private BookingController bookingController;

    @MockBean
    private BookingService bookingService;

    @MockBean
    private RegistrationFeign registrationFeign;

    @MockBean
    private SlotService slotService;

    /**
     * Method under test: {@link BookingController#getAvailableSlots(BookingEntity, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAvailableSlots() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.cognizant.bookingfacility.feign.RegistrationFeign.getTokenValidation(String)" because "this.feign" is null
        //       at com.cognizant.bookingfacility.controller.BookingController.getAvailableSlots(BookingController.java:45)
        //   See https://diff.blue/R013 to resolve this issue.

        BookingController bookingController = new BookingController();

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
        bookingController.getAvailableSlots("ABC123");
    }

    /**
     * Method under test: {@link BookingController#getAvailableSlots(BookingEntity, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAvailableSlots2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.cognizant.bookingfacility.feign.RegistrationFeign.getTokenValidation(String)" because "this.feign" is null
        //       at com.cognizant.bookingfacility.controller.BookingController.getAvailableSlots(BookingController.java:45)
        //   See https://diff.blue/R013 to resolve this issue.

        BookingController bookingController = new BookingController();
        BookingEntity bookingEntity = mock(BookingEntity.class);
        doNothing().when(bookingEntity).setBookingId(anyInt());
        doNothing().when(bookingEntity).setDateOfGame((LocalDate) any());
        doNothing().when(bookingEntity).setDob((LocalDate) any());
        doNothing().when(bookingEntity).setFirst_name((String) any());
        doNothing().when(bookingEntity).setGameName((GameEnum) any());
        doNothing().when(bookingEntity).setGroundNumber(anyInt());
        doNothing().when(bookingEntity).setLast_name((String) any());
        doNothing().when(bookingEntity).setPlayerId((String) any());
        doNothing().when(bookingEntity).setTimeOfGame((LocalTime) any());
        bookingEntity.setBookingId(123);
        bookingEntity.setDateOfGame(LocalDate.ofEpochDay(1L));
        bookingEntity.setDob(LocalDate.ofEpochDay(1L));
        bookingEntity.setFirst_name("Jane");
        bookingEntity.setGameName(GameEnum.CRICKET);
        bookingEntity.setGroundNumber(10);
        bookingEntity.setLast_name("Doe");
        bookingEntity.setPlayerId("42");
        bookingEntity.setTimeOfGame(LocalTime.of(1, 1));
        bookingController.getAvailableSlots("ABC123");
    }

    /**
     * Method under test: {@link BookingController#getAvailableSlots(String)}
     */
    @Test
    void testGetAvailableSlots3() throws Exception {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setToken("ABC123");
        playerResponse.setValid(true);
        when(registrationFeign.getTokenValidation((String) any())).thenReturn(playerResponse);
        when(slotService.getAllAvailableSlots()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/availableSlots")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

