package com.iiht.interviewtracker.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

@SuppressWarnings("deprecation")
@Data
public class UserDTO {

	private String userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String reportingTo;
	
	private String userType;
	
	private String userStatus;
	
	private String mobile;

}
