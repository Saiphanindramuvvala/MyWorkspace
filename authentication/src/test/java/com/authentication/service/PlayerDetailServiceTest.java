package com.authentication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.authentication.entity.Player;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PlayerDetailService.class})
@ExtendWith(SpringExtension.class)
class PlayerDetailServiceTest {
    @Autowired
    private PlayerDetailService playerDetailService;

    @MockBean
    private RegistrationService registrationService;

    /**
     * Method under test: {@link PlayerDetailService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
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
        Optional<Player> ofResult = Optional.of(player);
        when(registrationService.findByEmail((String) any())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = playerDetailService.loadUserByUsername("janedoe");
        assertTrue(actualLoadUserByUsernameResult.getAuthorities().isEmpty());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("jane.doe@example.org", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(registrationService).findByEmail((String) any());
    }

    /**
     * Method under test: {@link PlayerDetailService#loadUserByUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Cannot pass null or empty values to constructor
        //       at com.authentication.service.PlayerDetailService.loadUserByUsername(PlayerDetailService.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        Player player = mock(Player.class);
        when(player.getEmail()).thenReturn("");
        when(player.getPassword()).thenReturn("iloveyou");
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
        Optional<Player> ofResult = Optional.of(player);
        when(registrationService.findByEmail((String) any())).thenReturn(ofResult);
        playerDetailService.loadUserByUsername("janedoe");
    }

    /**
     * Method under test: {@link PlayerDetailService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        when(registrationService.findByEmail((String) any())).thenReturn(Optional.empty());
        Player player = mock(Player.class);
        when(player.getEmail()).thenReturn("jane.doe@example.org");
        when(player.getPassword()).thenReturn("iloveyou");
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
        assertThrows(UsernameNotFoundException.class, () -> playerDetailService.loadUserByUsername("janedoe"));
        verify(registrationService).findByEmail((String) any());
        verify(player).setAddress((String) any());
        verify(player).setAge(anyInt());
        verify(player).setCountry((String) any());
        verify(player).setCreationdate((LocalDateTime) any());
        verify(player).setDob((LocalDate) any());
        verify(player).setEmail((String) any());
        verify(player).setFname((String) any());
        verify(player).setId((String) any());
        verify(player).setLname((String) any());
        verify(player).setMobile((String) any());
        verify(player).setPan((String) any());
        verify(player).setPassword((String) any());
        verify(player).setState((String) any());
    }
}

