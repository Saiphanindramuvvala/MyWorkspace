package com.booking_facility.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SLOT_DETAILS")
public class Slot {

    public Slot(){}

    public Slot(int slot_id, boolean isAvailable, int groundNumber, int totalGround, GameEnum gameName) {
        this.slot_id = slot_id;
        this.isAvailable = isAvailable;
        this.groundNumber = groundNumber;
        this.totalGround = totalGround;
        this.gameName = gameName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slot_id;

    @Column(nullable = false)
    private boolean isAvailable;

    private int groundNumber;

    private int totalGround;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GameEnum gameName;

}
