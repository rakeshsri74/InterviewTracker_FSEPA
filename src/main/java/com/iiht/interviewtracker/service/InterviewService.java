package com.iiht.interviewtracker.service;

import java.util.List;

import com.iiht.interviewtracker.dto.AttendeeDTO;
import com.iiht.interviewtracker.dto.InterviewDTO;

public interface InterviewService {

	public InterviewDTO saveInterview(InterviewDTO interviewDTO);
	List<InterviewDTO> findAll();
	public InterviewDTO updateInterview(InterviewDTO interviewDTO);
	public InterviewDTO delete(String interviewId);
	public InterviewDTO findInterviewByName(String interviewName);
	public InterviewDTO findByInterviewerName(String interviewerName);
	public int countInterviews();
	public InterviewDTO addAttendee(String interviewId, String userId);
	public InterviewDTO showInterview(String interviewId);
}
