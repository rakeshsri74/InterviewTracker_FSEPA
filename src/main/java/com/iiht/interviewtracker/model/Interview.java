package com.iiht.interviewtracker.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "interviewmaster")
@Data
public class Interview {

	@Id
	private String interviewId;
	
	//private String interviewerName;
	
	private String interviewName;
	
	/*@ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private User user;
	*/
	private User interviewer;
	
	private String usersSkill;
	
	private String time;
	
	private String date;
	
	private String interviewStatus;
	
	private String technicalInterviewStatus;
	
	private String remarks;
	
}
