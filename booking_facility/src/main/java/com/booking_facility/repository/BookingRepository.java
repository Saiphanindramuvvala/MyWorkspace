package com.booking_facility.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking_facility.entity.BookingEntity;
import com.booking_facility.entity.GameEnum;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {


    Optional<BookingEntity> findFirstByGameNameOrderByGroundNumberDesc(GameEnum gameEnum);
    Optional<BookingEntity> findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc(GameEnum gameEnum, LocalDate dateOfGame, LocalTime timeOfGame);
}