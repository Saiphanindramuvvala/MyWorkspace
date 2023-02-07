package com.authentication.controller;

import com.authentication.exception.LoginException;
import com.authentication.exception.RegistrationException;
import com.authentication.entity.Player;
import com.authentication.vo.PlayerRequest;
import com.authentication.vo.PlayerResponse;
import com.authentication.service.LoginService;
import com.authentication.service.RegistrationService;
import com.authentication.service.ValidationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/player")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private LoginService loginService;
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private ValidationService validationService;

    @PostMapping(value = "/register",consumes = "application/json")
    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Register a player")
    public ResponseEntity<Player> registration(@Valid @RequestBody Player player) throws RegistrationException {
        Player registeredPlayer = registrationService.doRegistration(player);
        return new ResponseEntity<Player>(registeredPlayer, HttpStatus.CREATED);
    }

    @PostMapping(value="/login",consumes = "application/json")
    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Login a player")
    public ResponseEntity<PlayerResponse> login(@RequestBody PlayerRequest playerRequest) throws LoginException {
        return new ResponseEntity<PlayerResponse>(loginService.doLogin(playerRequest), HttpStatus.OK);
    }

    @GetMapping("/validatetoken")
    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Validate a token",security = { @SecurityRequirement(name = "bearer-key") })
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") final String token) {
        PlayerResponse response = validationService.validate(token);
        if(response.isValid())
            return new ResponseEntity<PlayerResponse>(response, HttpStatus.OK);
        PlayerResponse errRes = new PlayerResponse(null);
        errRes.setValid(false);
        return new ResponseEntity<>(errRes,HttpStatus.UNAUTHORIZED);
    }
}
