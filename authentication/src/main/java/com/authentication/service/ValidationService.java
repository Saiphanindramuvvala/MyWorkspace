package com.authentication.service;

import com.authentication.entity.Player;
import com.authentication.vo.PlayerResponse;
import com.authentication.repository.PlayerRepository;
import com.authentication.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class ValidationService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PlayerRepository playerRepository;

    public PlayerResponse validate(String token) {

        String jwt = token.substring(7);
        PlayerResponse response = null;
        if (jwtTokenUtil.validateToken(jwt)) {
            String playerUsername = jwtTokenUtil.getUsernameFromToken(jwt);
            Optional<Player> player = playerRepository.findByEmail(playerUsername);
            log.info(playerUsername);
            response = new PlayerResponse(token);
            response.setId(player.get().getId());
            response.setToken(jwt);
            response.setValid(true);
        } else {
            response.setValid(false);
        }
        return response;
    }
}