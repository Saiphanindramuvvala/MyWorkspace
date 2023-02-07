package com.cognizant.updateplayer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cognizant.updateplayer.entity.Player;
import com.cognizant.updateplayer.feign.RegistrationFeign;
import com.cognizant.updateplayer.service.UpdateService;
import com.cognizant.updateplayer.vo.PlayerResponse;
import com.cognizant.updateplayer.vo.UpdatePlayerVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/player")
@Slf4j
public class UpdatePlayerController {
    @Autowired
    private UpdateService s;

    @Autowired
    private RegistrationFeign feign;

    /** This method fetches player from db by id
     * @param id
     * @param token
     * @return playerById
     */
    @GetMapping("/getplayer/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Player> getPlayerById(@PathVariable String id, @RequestHeader("Authorization") final String token) {
        PlayerResponse response = feign.getTokenValidation(token);
        log.info(response.toString());
        Player player = s.getPlayerById(id);
        return new ResponseEntity<Player>(player, HttpStatus.CREATED);
    }

    /** This method fetches player from db by id and updates it
     * @param player
     * @param id
     * @param token
     * @return updatedPlayer
     * @return HttpStatus
     */
    @PutMapping("/update/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Player> updatePlayer(@Valid @RequestBody UpdatePlayerVo player, @PathVariable String id, @RequestHeader("Authorization") final String token) {
        PlayerResponse response = feign.getTokenValidation(token);
        log.info(response.toString());
        return new ResponseEntity<Player>(s.updatePlayer(player, id), HttpStatus.CREATED);
    }


}
