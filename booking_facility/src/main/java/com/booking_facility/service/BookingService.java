package com.booking_facility.service;

import com.booking_facility.entity.BookingEntity;
import com.booking_facility.entity.GameEnum;
import com.booking_facility.entity.GameDetails;
import com.booking_facility.repository.BookingRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
@Slf4j
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public BookingEntity doBooking(BookingEntity bookingEntity) {
    	 LocalDate dateNow = LocalDate.now();
         LocalTime timeNow = LocalTime.now();
         LocalDate gameDate = bookingEntity.getDateOfGame();
         LocalTime gameTime = bookingEntity.getTimeOfGame();
         boolean isPresentDate = gameDate.equals(dateNow);
         boolean isBeforePresentTime = gameTime.isBefore(timeNow);
         if(isPresentDate) {
             if(isBeforePresentTime) {
                 bookingEntity.setTimeOfGame(null);
                 BookingEntity b = bookingRepository.save(bookingEntity);
                 return b;
             }
         }
        if (bookingEntity.getGameName().equals(GameEnum.CRICKET)) {
            Optional<BookingEntity> existingBooking = bookingRepository.findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc(GameEnum.CRICKET, bookingEntity.getDateOfGame(), bookingEntity.getTimeOfGame());

            if (existingBooking.isPresent()) {
                if (existingBooking.get().getDateOfGame().isEqual(bookingEntity.getDateOfGame())) {
                    if (existingBooking.get().getTimeOfGame().equals(bookingEntity.getTimeOfGame())) {
                        int existGndNo = existingBooking.get().getGroundNumber();
                        if (existGndNo == GameDetails.CRICKET_GROUND) return null;
                        bookingEntity.setGroundNumber(existGndNo + 1);
                        BookingEntity b = bookingRepository.save(bookingEntity);
                        return b;
                    }
                }
            }
            bookingEntity.setGroundNumber(1);
            BookingEntity b = bookingRepository.save(bookingEntity);
            return b;
        }
        if (bookingEntity.getGameName().equals(GameEnum.FOOTBALL) && bookingEntity.getGroundNumber() <= GameDetails.FOOTBALL_GROUND) {
            Optional<BookingEntity> existBooking = bookingRepository.findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc(GameEnum.FOOTBALL, bookingEntity.getDateOfGame(), bookingEntity.getTimeOfGame());
            if (existBooking.isPresent()) {
                if (existBooking.get().getDateOfGame().isEqual(bookingEntity.getDateOfGame())) {
                    if (existBooking.get().getTimeOfGame().equals(bookingEntity.getTimeOfGame())) {
                        int existGndNo = existBooking.get().getGroundNumber();
                        if (existGndNo == GameDetails.FOOTBALL_GROUND) return null;
                        bookingEntity.setGroundNumber(existGndNo + 1);
                        BookingEntity b = bookingRepository.save(bookingEntity);
                        return b;
                    }
                }

            }
            bookingEntity.setGroundNumber(1);
            BookingEntity b = bookingRepository.save(bookingEntity);
            return b;
        }
        if (bookingEntity.getGameName().equals(GameEnum.BADMINTON)) {
            Optional<BookingEntity> existBooking = bookingRepository.findFirstByGameNameAndDateOfGameAndTimeOfGameOrderByGroundNumberDesc(GameEnum.BADMINTON, bookingEntity.getDateOfGame(), bookingEntity.getTimeOfGame());
            if (existBooking.isPresent()) {
                log.info(existBooking.toString());
                if (existBooking.get().getDateOfGame().isEqual(bookingEntity.getDateOfGame())) {
                    if (existBooking.get().getTimeOfGame().equals(bookingEntity.getTimeOfGame())) {
                        int existGndNo = existBooking.get().getGroundNumber();
                        if (existGndNo == GameDetails.BADMINTON_GROUND) return null;
                        bookingEntity.setGroundNumber(existGndNo + 1);
                        BookingEntity b = bookingRepository.save(bookingEntity);
                        return b;
                    }
                }
            }
            bookingEntity.setGroundNumber(1);
            BookingEntity b = bookingRepository.save(bookingEntity);
            return b;
        }
        return null;
    }
}
