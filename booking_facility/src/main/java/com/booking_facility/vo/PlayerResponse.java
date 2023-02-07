package com.booking_facility.vo;


import lombok.Data;

@Data
public class PlayerResponse {
    private String token;
    private boolean isValid;
    private String id;

}
