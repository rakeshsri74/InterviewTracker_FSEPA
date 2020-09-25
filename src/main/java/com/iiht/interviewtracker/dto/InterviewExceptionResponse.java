package com.iiht.interviewtracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewExceptionResponse {
	private String message;
	private long timeStamp;
	private int status;
}
