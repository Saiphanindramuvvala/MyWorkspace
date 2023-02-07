package com.cognizant.updateplayer.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UpdatePlayerVo {

	@Email(message = "Please give valid email.")
	private String email;

	@Pattern(regexp = "(^$|[0-9]{10})", message = "Contact no. should be 10 digits.")
	private String mobile;

	private String address;

	private String state;

	@Pattern(regexp = "(^$|[a-zA-Z0-9]{12})", message = "Please give, valid PAN.")
	private String pan;

}
