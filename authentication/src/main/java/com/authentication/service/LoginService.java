package com.authentication.service;


import com.authentication.exception.LoginException;
import com.authentication.vo.PlayerRequest;
import com.authentication.vo.PlayerResponse;
import com.authentication.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {

    @Autowired
    private PlayerDetailService playerDetailService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder encoder;

    public PlayerResponse doLogin(PlayerRequest playerRequest) throws LoginException {
        final UserDetails userdetails = playerDetailService.loadUserByUsername(playerRequest.getUsername());
        log.info(userdetails.toString());
        PlayerResponse response;
        // Check DATABASE_PASSWORD== REQUESTED_PASSWORD
        if (encoder.matches(playerRequest.getPassword(), userdetails.getPassword())) {
            String token = jwtTokenUtil.generateToken(userdetails);
            response = new PlayerResponse(token);
            response.setValid(true);
        } else {
            throw new LoginException("LOGIN FAILED! CHECK PASSWORD");
        }
        return response;
    }
}
