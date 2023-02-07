package com.cognizant.updateplayer.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.cognizant.updateplayer.entity.Player;
import com.cognizant.updateplayer.feign.RegistrationFeign;
import com.cognizant.updateplayer.service.UpdateService;
import com.cognizant.updateplayer.vo.PlayerResponse;
import com.cognizant.updateplayer.vo.UpdatePlayerVo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UpdatePlayerController.class})
@ExtendWith(SpringExtension.class)
class UpdatePlayerControllerTest {
    @MockBean
    private RegistrationFeign registrationFeign;

    @Autowired
    private UpdatePlayerController updatePlayerController;

    @MockBean
    private UpdateService updateService;

    /**
     * Method under test: {@link UpdatePlayerController#getPlayerById(String, String)}
     */
    @Test
    void testGetPlayerById() throws Exception {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setId("42");
        playerResponse.setToken("ABC123");
        playerResponse.setValid(true);
        when(registrationFeign.getTokenValidation((String) any())).thenReturn(playerResponse);

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
        when(updateService.getPlayerById((String) any())).thenReturn(player);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/player/getplayer/{id}", "42")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(updatePlayerController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":\"42\",\"fname\":\"Fname\",\"lname\":\"Lname\",\"email\":\"jane.doe@example.org\",\"age\":1,\"dob\":[1970,1,2],"
                                        + "\"mobile\":\"Mobile\",\"address\":\"42 Main St\",\"state\":\"MD\",\"country\":\"GB\",\"pan\":\"Pan\",\"creationdate\":[1,1"
                                        + ",1,1,1],\"password\":\"iloveyou\"}"));
    }

    /**
     * Method under test: {@link UpdatePlayerController#getPlayerById(String, String)}
     */
    @Test
    void testGetPlayerById2() throws Exception {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setId("42");
        playerResponse.setToken("ABC123");
        playerResponse.setValid(true);
        when(registrationFeign.getTokenValidation((String) any())).thenReturn(playerResponse);

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
        when(updateService.getPlayerById((String) any())).thenReturn(player);

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("?");
        player1.setId("42");
        player1.setLname("?");
        player1.setMobile("?");
        player1.setPan("?");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/player/getplayer/{id}", "42")
                .header("Authorization", player1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(updatePlayerController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":\"42\",\"fname\":\"Fname\",\"lname\":\"Lname\",\"email\":\"jane.doe@example.org\",\"age\":1,\"dob\":[1970,1,2],"
                                        + "\"mobile\":\"Mobile\",\"address\":\"42 Main St\",\"state\":\"MD\",\"country\":\"GB\",\"pan\":\"Pan\",\"creationdate\":[1,1"
                                        + ",1,1,1],\"password\":\"iloveyou\"}"));
    }

    /**
     * Method under test: {@link UpdatePlayerController#updatePlayer(UpdatePlayerVo, String, String)}
     */
    @Test
    void testUpdatePlayer() throws Exception {
        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("MD");
        String content = (new ObjectMapper()).writeValueAsString(updatePlayerVo);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/player/update/{id}", "42")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(updatePlayerController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

