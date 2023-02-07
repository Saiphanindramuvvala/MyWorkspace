package com.cognizant.updateplayer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.updateplayer.vo.PlayerResponse;


@FeignClient(name="authentication-service", url = "http://localhost:8081")
public interface RegistrationFeign {
	   @GetMapping("/player/validatetoken")
	    public PlayerResponse getTokenValidation(@RequestHeader(name= "Authorization", required= true) String token);

//	    @GetMapping("/getuserid/{username}")
//	    public int getUserId(@PathVariable String username);

}
