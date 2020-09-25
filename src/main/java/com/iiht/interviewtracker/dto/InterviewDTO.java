package com.iiht.interviewtracker.dto;

import java.util.List;

import lombok.Data;

@SuppressWarnings("deprecation")
@Data
public class InterviewDTO {

	private String interviewId;
	
	//private String interviewerName;
	
	private UserDTO interviewer;
	
	private String interviewName;
	
	private String usersSkill;
	
	private String time;
	
	private String date;
	
	private String interviewStatus;
	
	private String technicalInterviewStatus;
	
	private String remarks;
	
	private List<UserDTO> attendee;

}
