package com.authentication.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "player_tbl")
@Data
public class Player {
    @Id
    @GenericGenerator(name = "playerId-sequence", strategy = "com.authentication.config.PlayerIdGenerator")
    @GeneratedValue(generator = "playerId-sequence", strategy = GenerationType.SEQUENCE)
    private String id;

    @NotNull(message = "Firstname cannot be null.")
    @NotBlank(message = "Firstname cannot be blank.")
    private String fname;

    @NotNull(message = "Lastname cannot be null.")
    @NotBlank(message = "Lastname cannot be blank.")
    private String lname;
    @Email(message = "Please give valid email.")
    @NotNull(message = "Email cannot be null.")
    @NotBlank(message = "Email cannot be blank.")
    private String email;

    @Min(value = 18, message = "Age must be greater than 18.")
    private int age;
    @Past(message = "DOB should be less than today date.")
    @NotNull(message = "DOB cannot be empty.")
    private LocalDate dob;
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Contact no. should be 10 digits.")
    @NotBlank(message = "Contact no. cannot be blank.")
    private String mobile;

    @NotNull(message = "Address cannot be null.")
    @NotBlank(message = "Address cannot be blank.")
    private String address;

    @NotNull(message = "State cannot be null.")
    @NotBlank(message = "State cannot be blank.")
    private String state;

    @NotNull(message = "Country cannot be null.")
    @NotBlank(message = "Country cannot be blank.")
    private String country;
    @Pattern(regexp = "(^$|[a-zA-Z0-9]{12})", message = "Please give, valid PAN.")
    @NotBlank(message = "PAN cannot be blank.")
    private String pan;
    @CreationTimestamp
    private LocalDateTime creationdate;

    @NotNull(message = "Please give, valid password.")
    @NotBlank(message = "Password cannot be blank.")
    private String password;

}