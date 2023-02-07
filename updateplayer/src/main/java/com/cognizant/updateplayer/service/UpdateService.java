package com.cognizant.updateplayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.updateplayer.entity.Player;
import com.cognizant.updateplayer.repository.UpdatePlayerRepo;
import com.cognizant.updateplayer.vo.UpdatePlayerVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UpdateService {
	@Autowired
	private UpdatePlayerRepo repo;
	
	public Player updatePlayer(UpdatePlayerVo player, String id) {
		Optional<Player> existingPlayer= repo.findById(id);
		log.info(player.toString());
		Player oldPlayer= existingPlayer.get();
		if(player.getEmail()!= null) {
			oldPlayer.setEmail(player.getEmail());
		}
		if(player.getPan()!= null) {
			oldPlayer.setPan(player.getPan());
		}
		if(player.getMobile()!= null) {
			oldPlayer.setMobile(player.getMobile());
		}
		if(player.getState()!= null) {
			oldPlayer.setState(player.getState());
		}
		if(player.getAddress()!= null) {
			oldPlayer.setAddress(player.getAddress());
		}
		Player updatedPlayer= repo.save(oldPlayer);
		return updatedPlayer;
	}

	public Player getPlayerById(String id) {
		Optional<Player> player = repo.findById(id);
		log.info(player.get().toString());
		return player.get();
	}

}
