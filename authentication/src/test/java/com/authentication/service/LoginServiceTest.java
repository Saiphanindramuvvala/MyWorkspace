package com.authentication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.authentication.exception.LoginException;
import com.authentication.utils.JwtTokenUtil;
import com.authentication.vo.PlayerRequest;
import com.authentication.vo.PlayerResponse;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {LoginService.class})
@ExtendWith(SpringExtension.class)
class LoginServiceTest {
    @MockBean
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private LoginService loginService;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private PlayerDetailService playerDetailService;

    @MockBean
    private RegistrationService registrationService;

    /**
     * Method under test: {@link LoginService#doLogin(PlayerRequest)}
     */
    @Test
    void testDoLogin() throws LoginException, UsernameNotFoundException {
        when(jwtTokenUtil.generateToken((UserDetails) any())).thenReturn("ABC123");
        when(playerDetailService.loadUserByUsername((String) any()))
                .thenReturn(new User("janedoe", "iloveyou", new ArrayList<>()));
        when(passwordEncoder.matches((CharSequence) any(), (String) any())).thenReturn(true);

        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setPassword("iloveyou");
        playerRequest.setUsername("janedoe");
        PlayerResponse actualDoLoginResult = loginService.doLogin(playerRequest);
        assertEquals("ABC123", actualDoLoginResult.getToken());
        assertTrue(actualDoLoginResult.isValid());
        verify(jwtTokenUtil).generateToken((UserDetails) any());
        verify(playerDetailService).loadUserByUsername((String) any());
        verify(passwordEncoder).matches((CharSequence) any(), (String) any());
    }

    /**
     * Method under test: {@link LoginService#doLogin(PlayerRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoLogin2() throws LoginException, UsernameNotFoundException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.core.userdetails.UserDetails.getPassword()" because "userdetails" is null
        //       at com.authentication.service.LoginService.doLogin(LoginService.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        when(jwtTokenUtil.generateToken((UserDetails) any())).thenReturn("ABC123");
        when(playerDetailService.loadUserByUsername((String) any())).thenReturn(null);
        when(passwordEncoder.matches((CharSequence) any(), (String) any())).thenReturn(true);

        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setPassword("iloveyou");
        playerRequest.setUsername("janedoe");
        loginService.doLogin(playerRequest);
    }

    /**
     * Method under test: {@link LoginService#doLogin(PlayerRequest)}
     */
    @Test
    void testDoLogin3() throws LoginException, UsernameNotFoundException {
        when(jwtTokenUtil.generateToken((UserDetails) any())).thenReturn("ABC123");
        when(playerDetailService.loadUserByUsername((String) any()))
                .thenReturn(new User("janedoe", "iloveyou", new ArrayList<>()));
        when(passwordEncoder.matches((CharSequence) any(), (String) any())).thenReturn(false);

        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setPassword("iloveyou");
        playerRequest.setUsername("janedoe");
        assertThrows(LoginException.class, () -> loginService.doLogin(playerRequest));
        verify(playerDetailService).loadUserByUsername((String) any());
        verify(passwordEncoder).matches((CharSequence) any(), (String) any());
    }
}

