package com.authentication.service;

import com.authentication.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PlayerDetailService implements UserDetailsService {
    @Autowired
    private RegistrationService service;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<Player> player = service.findByEmail(username);
        if (player.isPresent()) {
            return new User(player.get().getEmail(), player.get().getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Player not found!");
        }
    }
}
