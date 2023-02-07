package com.authentication.vo;


import lombok.Data;

@Data
public class PlayerResponse {
    private String token;
    private boolean isValid;
    private String id;

    public PlayerResponse(String token) {
        this.token = token;
    }
}
