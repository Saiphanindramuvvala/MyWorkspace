package com.booking_facility.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking_facility.entity.Slot;

public interface SlotRepository extends JpaRepository<Slot, Integer> {
}