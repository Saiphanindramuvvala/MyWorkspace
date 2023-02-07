package com.booking_facility.vo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingResponse {
    private String response;
    private int bookingId;
    private String playerId;
    private int groundNumber;
    private String gameName;
    private LocalTime timeOfGame;
    private LocalDate dateOfGame;
}
