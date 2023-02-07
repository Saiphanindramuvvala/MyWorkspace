package com.authentication.repository;

import com.authentication.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player,String> {
    Optional<Player> findByEmail(@NotNull String email);

}
