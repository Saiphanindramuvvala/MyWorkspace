package com.booking_facility;

import com.booking_facility.entity.GameEnum;
import com.booking_facility.entity.GameDetails;
import com.booking_facility.entity.Slot;
import com.booking_facility.repository.SlotRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class BookingFacilityApplication {

    @Autowired
    private SlotRepository slotRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookingFacilityApplication.class, args);
    }

    @PostConstruct
    public void doInject() {
        List<Slot> slotDetails = Arrays.asList(
                new Slot(1,true,0,GameDetails.CRICKET_GROUND,GameEnum.CRICKET),
                new Slot(2,true,0,GameDetails.FOOTBALL_GROUND,GameEnum.FOOTBALL),
                new Slot(3,true,0,GameDetails.BADMINTON_GROUND,GameEnum.BADMINTON)

        );
        slotRepository.saveAll(slotDetails);
    }
}
