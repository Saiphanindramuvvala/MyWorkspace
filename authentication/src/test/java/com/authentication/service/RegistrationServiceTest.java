package com.authentication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.authentication.exception.RegistrationException;
import com.authentication.entity.Player;
import com.authentication.repository.PlayerRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RegistrationService.class})
@ExtendWith(SpringExtension.class)
class RegistrationServiceTest {
    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private PlayerRepository playerRepository;

    @Autowired
    private RegistrationService registrationService;

    /**
     * Method under test: {@link RegistrationService#findByEmail(String)}
     */
    @Test
    void testFindByEmail() {
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
        when(playerRepository.findByEmail((String) any())).thenReturn(ofResult);
        Optional<Player> actualFindByEmailResult = registrationService.findByEmail("jane.doe@example.org");
        assertSame(ofResult, actualFindByEmailResult);
        assertTrue(actualFindByEmailResult.isPresent());
        verify(playerRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link RegistrationService#doRegistration(Player)}
     */
    @Test
    void testDoRegistration() throws RegistrationException {
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

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        Optional<Player> ofResult = Optional.of(player1);
        when(playerRepository.save((Player) any())).thenReturn(player);
        when(playerRepository.findByEmail((String) any())).thenReturn(ofResult);

        Player player2 = new Player();
        player2.setAddress("42 Main St");
        player2.setAge(1);
        player2.setCountry("GB");
        player2.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player2.setDob(LocalDate.ofEpochDay(1L));
        player2.setEmail("jane.doe@example.org");
        player2.setFname("Fname");
        player2.setId("42");
        player2.setLname("Lname");
        player2.setMobile("Mobile");
        player2.setPan("Pan");
        player2.setPassword("iloveyou");
        player2.setState("MD");
        assertThrows(RegistrationException.class, () -> registrationService.doRegistration(player2));
        verify(playerRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link RegistrationService#doRegistration(Player)}
     */
    @Test
    void testDoRegistration2() throws RegistrationException {
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
        when(playerRepository.save((Player) any())).thenReturn(player);
        when(playerRepository.findByEmail((String) any())).thenReturn(Optional.empty());
        when(passwordEncoder.encode((CharSequence) any())).thenReturn("secret");

        Player player1 = new Player();
        player1.setAddress("42 Main St");
        player1.setAge(1);
        player1.setCountry("GB");
        player1.setCreationdate(LocalDateTime.of(1, 1, 1, 1, 1));
        player1.setDob(LocalDate.ofEpochDay(1L));
        player1.setEmail("jane.doe@example.org");
        player1.setFname("Fname");
        player1.setId("42");
        player1.setLname("Lname");
        player1.setMobile("Mobile");
        player1.setPan("Pan");
        player1.setPassword("iloveyou");
        player1.setState("MD");
        assertSame(player, registrationService.doRegistration(player1));
        verify(playerRepository).save((Player) any());
        verify(playerRepository).findByEmail((String) any());
        verify(passwordEncoder).encode((CharSequence) any());
        assertEquals("secret", player1.getPassword());
        assertEquals("PAN", player1.getPan());
    }
}

