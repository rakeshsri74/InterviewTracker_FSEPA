package com.iiht.interviewtracker.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "usermaster")
@Data
public class User {

	@Id
	private String userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String reportingTo;
	
	private String userType;
	
	private String userStatus;
	
	private String mobile;
	
		
}
