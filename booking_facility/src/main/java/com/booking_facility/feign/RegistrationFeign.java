package com.booking_facility.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.booking_facility.vo.PlayerResponse;


@FeignClient(name="authentication-service", url = "http://localhost:8081")
public interface RegistrationFeign {
	   @GetMapping("/player/validatetoken")
	    public PlayerResponse getTokenValidation(@RequestHeader(name= "Authorization") String token);


}
