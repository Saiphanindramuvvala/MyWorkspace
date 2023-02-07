package com.cognizant.updateplayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.updateplayer.entity.Player;

import java.util.Optional;

public interface UpdatePlayerRepo extends JpaRepository<Player, String> {

    Optional<Player> findByEmail(String username);
}
