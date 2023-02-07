package com.authentication.service;


import com.authentication.exception.RegistrationException;
import com.authentication.entity.Player;
import com.authentication.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private PlayerRepository playerRepository;

    public Optional<Player> findByEmail(String email) {
        Optional<Player> existingPlayer = playerRepository.findByEmail(email);
        return existingPlayer;
    }

    public Player doRegistration(Player player) throws RegistrationException {
        Optional<Player> existingPlayer = playerRepository.findByEmail(player.getEmail());
        if (existingPlayer.isPresent()) {
            throw new RegistrationException("Player is already available.");
        }
        LocalDate today = LocalDate.now();
        LocalDate playerDob = player.getDob();
        int playerAge = Period.between(playerDob, today).getYears();
        player.setAge(playerAge);
        player.setPan(player.getPan().toUpperCase());
        player.setPassword(encoder.encode(player.getPassword()));
        return playerRepository.save(player);
    }
}

