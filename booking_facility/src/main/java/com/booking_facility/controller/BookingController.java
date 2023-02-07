package com.booking_facility.controller;

import com.booking_facility.entity.BookingEntity;
import com.booking_facility.entity.Slot;
import com.booking_facility.exception.SlotUnavailableException;
import com.booking_facility.feign.RegistrationFeign;
import com.booking_facility.service.BookingService;
import com.booking_facility.service.SlotService;
import com.booking_facility.vo.BookingResponse;
import com.booking_facility.vo.PlayerResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@Slf4j
public class BookingController {

    @Autowired
    private SlotService slotService;

    @Autowired
    private BookingService bookingService;
    
    @Autowired
    private RegistrationFeign feign;

    @GetMapping("/availableSlots")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Slot>> getAvailableSlots(@RequestHeader("Authorization") String token) {
    	PlayerResponse response = feign.getTokenValidation(token);
    	log.info(response.toString());
        return new ResponseEntity<List<Slot>>(slotService.getAllAvailableSlots(), HttpStatus.OK);
    }

    @PostMapping("/book")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<BookingResponse> bookSlots(@RequestBody BookingEntity bookingSlot, @RequestHeader("Authorization") final String token) throws SlotUnavailableException {
    	PlayerResponse response = feign.getTokenValidation(token);
    	log.info(response.toString());
        log.info(bookingSlot.toString());
        BookingResponse resp = new BookingResponse();
        LocalTime startTime= LocalTime.parse("06:00:00");
        LocalTime endTime= LocalTime.parse("22:00:00");
        LocalTime time= LocalTime.parse(bookingSlot.getTimeOfGame().toString());
        if(time.isBefore(startTime) || time.isAfter(endTime)) {
        	resp.setResponse("Invalid Time slot, Try From 6:00 AM to 10:00 PM");
            return new ResponseEntity<BookingResponse>(resp, HttpStatus.NOT_FOUND);
        }
        BookingEntity bookedSlot = bookingService.doBooking(bookingSlot);
        
        if (bookedSlot != null) {
            resp.setResponse("Booking Success");
            resp.setBookingId(bookedSlot.getBookingId());
            resp.setPlayerId(bookedSlot.getPlayerId());
            resp.setDateOfGame(bookedSlot.getDateOfGame());
            resp.setGroundNumber(bookedSlot.getGroundNumber());
            resp.setTimeOfGame(bookedSlot.getTimeOfGame());
            resp.setGameName(bookedSlot.getGameName().toString());
            return new ResponseEntity<BookingResponse>(resp, HttpStatus.OK);
        }
        resp.setResponse("ALREADY SLOT BOOKED! TRY WITH ANOTHER TIME SLOT");
        throw new SlotUnavailableException("Slot Already booked, try another slot");
//        return new ResponseEntity<BookingResponse>(resp, HttpStatus.NOT_FOUND);
    }


}
