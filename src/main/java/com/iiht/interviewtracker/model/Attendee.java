package com.iiht.interviewtracker.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "attendeemaster")
@Data
public class Attendee {
	
	private String interviewId;
	
	private String attendeeId;
}
