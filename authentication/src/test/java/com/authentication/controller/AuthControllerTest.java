package com.authentication.controller;

import static org.mockito.Mockito.any;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.authentication.entity.Player;
import com.authentication.exception.RegistrationException;
import com.authentication.service.LoginService;
import com.authentication.service.RegistrationService;
import com.authentication.service.ValidationService;
import com.authentication.vo.PlayerRequest;
import com.authentication.vo.PlayerResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthController.class})
@ExtendWith(SpringExtension.class)
class AuthControllerTest {
    @Autowired
    private AuthController authController;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private LoginService loginService;

    @MockBean
    private RegistrationService registrationService;

    @MockBean
    private ValidationService validationService;

    /**
     * Method under test: {@link AuthController#login(PlayerRequest)}
     */
    @Test
    void testLogin() throws Exception {
        when(loginService.doLogin((PlayerRequest) any())).thenReturn(new PlayerResponse("ABC123"));

        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setPassword("iloveyou");
        playerRequest.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(playerRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/player/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"token\":\"ABC123\",\"valid\":false}"));
    }

    /**
     * Method under test: {@link AuthController#registration(Player)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegistration() throws RegistrationException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.authentication.service.RegistrationService.doRegistration(com.authentication.model.Player)" because "this.registrationService" is null
        //       at com.authentication.controller.AuthController.registration(AuthController.java:46)
        //   See https://diff.blue/R013 to resolve this issue.

        AuthController authController = new AuthController();

        Player player = new Player();
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");
        authController.registration(player);
    }

    /**
     * Method under test: {@link AuthController#registration(Player)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegistration2() throws RegistrationException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.authentication.service.RegistrationService.doRegistration(com.authentication.model.Player)" because "this.registrationService" is null
        //       at com.authentication.controller.AuthController.registration(AuthController.java:46)
        //   See https://diff.blue/R013 to resolve this issue.

        AuthController authController = new AuthController();
        Player player = mock(Player.class);
        doNothing().when(player).setAddress((String) any());
        doNothing().when(player).setAge(anyInt());
        doNothing().when(player).setCountry((String) any());
        doNothing().when(player).setCreationdate((LocalDateTime) any());
        doNothing().when(player).setDob((LocalDate) any());
        doNothing().when(player).setEmail((String) any());
        doNothing().when(player).setFname((String) any());
        doNothing().when(player).setId((String) any());
        doNothing().when(player).setLname((String) any());
        doNothing().when(player).setMobile((String) any());
        doNothing().when(player).setPan((String) any());
        doNothing().when(player).setPassword((String) any());
        doNothing().when(player).setState((String) any());
        player.setAddress("42 Main St");
        player.setAge(1);
        player.setCountry("GB");
        player.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player.setDob(LocalDate.ofEpochDay(1L));
        player.setEmail("jane.doe@example.org");
        player.setFname("Fname");
        player.setId("42");
        player.setLname("Lname");
        player.setMobile("Mobile");
        player.setPan("Pan");
        player.setPassword("iloveyou");
        player.setState("MD");
        authController.registration(player);
    }

    /**
     * Method under test: {@link AuthController#validateToken(String)}
     */
    @Test
    void testValidateToken() throws Exception {
        when(validationService.validate((String) any())).thenReturn(new PlayerResponse("ABC123"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/player/validatetoken")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(401));
    }

    /**
     * Method under test: {@link AuthController#validateToken(String)}
     */
    @Test
    void testValidateToken2() throws Exception {
        PlayerResponse playerResponse = new PlayerResponse("ABC123");
        playerResponse.setValid(true);
        when(validationService.validate((String) any())).thenReturn(playerResponse);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/player/validatetoken")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"token\":\"ABC123\",\"valid\":true}"));
    }
}

