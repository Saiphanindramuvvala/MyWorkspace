package com.authentication.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class PlayerRequest {

    @Email
    @NotNull
    private String username;
    @NotNull
    @Pattern(regexp = "(^$|(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,12})")
    private String password;
}
