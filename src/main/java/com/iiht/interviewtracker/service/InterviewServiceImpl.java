package com.iiht.interviewtracker.service;

import static com.iiht.interviewtracker.utils.InterviewUtilities.convertToInterview;
import static com.iiht.interviewtracker.utils.InterviewUtilities.convertToInterviewDto;
import static com.iiht.interviewtracker.utils.InterviewUtilities.convertToInterviewDtoList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.interviewtracker.dto.InterviewDTO;
import com.iiht.interviewtracker.model.Interview;
import com.iiht.interviewtracker.repository.InterviewRepository;

@Service
public class InterviewServiceImpl implements InterviewService {

	@Autowired
    private InterviewRepository interviewRepository;
	
	@Override
	public InterviewDTO saveInterview(InterviewDTO interviewDTO) {
		return null;
	}

	@Override
	public List<InterviewDTO> findAll() {
		return null;
	}

	@Override
	public InterviewDTO updateInterview(InterviewDTO interviewDTO) {
		return null;
	}

	@Override
	public InterviewDTO delete(String interviewId) {
		return null;
	}

	@Override
	public InterviewDTO findInterviewByName(String interviewName) {
		return null;
	}

	@Override
	public InterviewDTO findByInterviewerName(String interviewerName) {
		return null;
	}

	@Override
	public int countInterviews() {
		return 0;
		
	}

	@Override
	public InterviewDTO addAttendee(String interviewId,String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InterviewDTO showInterview(String interviewId) {
		// TODO Auto-generated method stub
		return null;
	}

}
