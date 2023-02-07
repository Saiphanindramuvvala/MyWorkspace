package com.booking_facility.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "BOOKING_DETAILS")
@Data
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    @NotNull
    private String playerId;
    @NotNull
    private String first_name;
    @NotNull
    private String last_name;
    @NotNull
    private LocalDate dob;
    @NotNull
    @FutureOrPresent(message = "Date cannot be past")
    private LocalDate dateOfGame;
    @NotNull(message = "time cannot be blank")
    private LocalTime timeOfGame;
    private int groundNumber;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GameEnum gameName;
}
