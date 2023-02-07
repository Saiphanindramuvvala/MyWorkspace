package com.cognizant.updateplayer.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cognizant.updateplayer.entity.Player;
import com.cognizant.updateplayer.repository.UpdatePlayerRepo;
import com.cognizant.updateplayer.vo.UpdatePlayerVo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UpdateService.class})
@ExtendWith(SpringExtension.class)
class UpdateServiceTest {
    @MockBean
    private UpdatePlayerRepo updatePlayerRepo;

    @Autowired
    private UpdateService updateService;

    /**
     * Method under test: {@link UpdateService#updatePlayer(UpdatePlayerVo, String)}
     */
    @Test
    void testUpdatePlayer() {
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
        when(updatePlayerRepo.save((Player) any())).thenReturn(player1);
        when(updatePlayerRepo.findById((String) any())).thenReturn(ofResult);

        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("MD");
        assertSame(player1, updateService.updatePlayer(updatePlayerVo, "42"));
        verify(updatePlayerRepo).save((Player) any());
        verify(updatePlayerRepo).findById((String) any());
    }

    /**
     * Method under test: {@link UpdateService#updatePlayer(UpdatePlayerVo, String)}
     */
    @Test
    void testUpdatePlayer2() {
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
        Optional<Player> ofResult = Optional.of(player);

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
        when(updatePlayerRepo.save((Player) any())).thenReturn(player1);
        when(updatePlayerRepo.findById((String) any())).thenReturn(ofResult);

        UpdatePlayerVo updatePlayerVo = new UpdatePlayerVo();
        updatePlayerVo.setAddress("42 Main St");
        updatePlayerVo.setEmail("jane.doe@example.org");
        updatePlayerVo.setMobile("Mobile");
        updatePlayerVo.setPan("Pan");
        updatePlayerVo.setState("MD");
        assertSame(player1, updateService.updatePlayer(updatePlayerVo, "42"));
        verify(updatePlayerRepo).save((Player) any());
        verify(updatePlayerRepo).findById((String) any());
        verify(player, atLeast(1)).setAddress((String) any());
        verify(player).setAge(anyInt());
        verify(player).setCountry((String) any());
        verify(player).setCreationdate((LocalDateTime) any());
        verify(player).setDob((LocalDate) any());
        verify(player, atLeast(1)).setEmail((String) any());
        verify(player).setFname((String) any());
        verify(player).setId((String) any());
        verify(player).setLname((String) any());
        verify(player, atLeast(1)).setMobile((String) any());
        verify(player, atLeast(1)).setPan((String) any());
        verify(player).setPassword((String) any());
        verify(player, atLeast(1)).setState((String) any());
    }

    /**
     * Method under test: {@link UpdateService#getPlayerById(String)}
     */
    @Test
    void testGetPlayerById() {
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
        when(updatePlayerRepo.findById((String) any())).thenReturn(ofResult);
        assertSame(player, updateService.getPlayerById("42"));
        verify(updatePlayerRepo).findById((String) any());
    }

    /**
     * Method under test: {@link UpdateService#getPlayerById(String)}
     */
    @Test
    void testGetPlayerById2() {
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
        Optional<Player> ofResult = Optional.of(player);
        when(updatePlayerRepo.findById((String) any())).thenReturn(ofResult);
        updateService.getPlayerById("42");
        verify(updatePlayerRepo).findById((String) any());
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

    /**
     * Method under test: {@link UpdateService#getPlayerById(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPlayerById3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:143)
        //       at com.cognizant.updateplayer.service.UpdateService.getPlayerById(UpdateService.java:45)
        //   See https://diff.blue/R013 to resolve this issue.

        when(updatePlayerRepo.findById((String) any())).thenReturn(Optional.empty());
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
        updateService.getPlayerById("42");
    }
}

