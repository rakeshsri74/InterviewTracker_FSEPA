package com.iiht.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iiht.interviewtracker.dto.InterviewDTO;
import com.iiht.interviewtracker.dto.UserDTO;
import com.iiht.interviewtracker.model.Interview;
import com.iiht.interviewtracker.model.User;

public class MasterData {

	public static UserDTO getUserDto() {
		UserDTO userdto = new UserDTO();
		
		userdto.setUserId("1");
		userdto.setFirstName("Rakesh");
		userdto.setLastName("Srivastava");
		userdto.setReportingTo("Sandeep");
		userdto.setUserStatus("Active");
		userdto.setUserType("Admin");
		userdto.setMobile("7612398345");
		userdto.setEmail("yaksha@iiht.com");
		
		return userdto;
	}
	
	public static User getUser() {
		User user = new User();
		
		user.setUserId("1");
		user.setFirstName("Rakesh");
		user.setLastName("Srivastava");
		user.setReportingTo("Sandeep");
		user.setUserStatus("Active");
		user.setUserType("Admin");
		user.setMobile("7612398345");
		user.setEmail("yaksha@iiht.com");
		
		return user;
	}
	
	public static InterviewDTO getInterviewDto() {
		InterviewDTO interviewdto = new InterviewDTO();

		UserDTO user = new UserDTO();
		
		user.setUserId("1");
		user.setFirstName("Rakesh");
		user.setLastName("Srivastava");
		user.setReportingTo("Sandeep");
		user.setUserStatus("Active");
		user.setUserType("Admin");
		user.setMobile("7612398345");
		user.setEmail("yaksha@iiht.com");
		
		List<UserDTO> list = new  ArrayList<UserDTO>();
		list.add(user);
		
		interviewdto.setInterviewId("1");
		interviewdto.setInterviewName("Java");
		//interviewdto.setInterviewerName("Satyam");
		interviewdto.setInterviewer(user);
		interviewdto.setDate("12/12/2019");
		interviewdto.setInterviewStatus("Pass");
		interviewdto.setRemarks("Candidate got selected");
		interviewdto.setTechnicalInterviewStatus("Selected");
		interviewdto.setTime("1:12");
		//interviewdto.setUserForInterview("Rakesh");
		interviewdto.setUsersSkill("Java");
		interviewdto.setAttendee(list);
		
		return interviewdto;
	}
	
	public static Interview getInterview() {
		Interview interview = new Interview();
		User user = new User();
		
		user.setUserId("1");
		user.setFirstName("Rakesh");
		user.setLastName("Srivastava");
		user.setReportingTo("Sandeep");
		user.setUserStatus("Active");
		user.setUserType("Admin");
		user.setMobile("7612398345");
		user.setEmail("yaksha@iiht.com");
		
		interview.setInterviewId("1");
		interview.setInterviewName("Java");
		interview.setInterviewer(user);
		interview.setDate("12/12/2019");
		interview.setInterviewStatus("Pass");
		interview.setRemarks("Candidate got selected");
		interview.setTechnicalInterviewStatus("Selected");
		interview.setTime("1:12");
		//interview.setUserForInterview("Rakesh");
		interview.setUsersSkill("Java");
		
		return interview;
		
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	public static byte[] toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
	
	 
}
