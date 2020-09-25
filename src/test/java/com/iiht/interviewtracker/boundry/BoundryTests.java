package com.iiht.interviewtracker.boundry;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.iiht.interviewtracker.dto.*;
import com.iiht.utils.MasterData;
import static com.iiht.utils.MasterData.*;
import static com.iiht.utils.TestUtils.boundaryTestFile;
import static com.iiht.utils.TestUtils.currentTest;
import static com.iiht.utils.TestUtils.yakshaAssert;

public class BoundryTests {

	private Validator validator;
	  
	  @BeforeEach 
	  public void setUp() { 
		  ValidatorFactory factory = Validation.buildDefaultValidatorFactory(); 
		  validator = factory.getValidator(); 
	}
	  
	  @Test
		public void testFirstNameLength() throws Exception {
			UserDTO user = MasterData.getUserDto();
			user.setFirstName("Ra");
			Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
			yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
		}	  
	  
	  @Test
		public void testLastNameLength() throws Exception {
			UserDTO user = MasterData.getUserDto();
			user.setLastName("Sri");
			Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
			yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
		}
	  
	  @Test
		public void testEmailLength() throws Exception {
			UserDTO user = MasterData.getUserDto();
			user.setEmail("Ra");
			Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
			yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
		}
	  
	  @Test
		public void testReportingToLength() throws Exception {
			UserDTO user = MasterData.getUserDto();
			user.setReportingTo("San");
			Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
			yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
		}
	  
	  @Test
		public void testUserTypeLength() throws Exception {
			UserDTO user = MasterData.getUserDto();
			user.setUserType("Ad");
			Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
			yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
		}
	  
	  @Test
		public void testUserStatusLength() throws Exception {
			UserDTO user = MasterData.getUserDto();
			user.setUserStatus("Act");
			Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
			yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
		}
	  
	  @Test
		public void testMobileLength() throws Exception {
			UserDTO user = MasterData.getUserDto();
			user.setUserStatus("98738");
			Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
			yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
		}
	  
	  @Test
		public void testInterviewerNameLength() throws Exception {
			InterviewDTO interview = MasterData.getInterviewDto();
			UserDTO user = MasterData.getUserDto();
			interview.setInterviewer(user);
			Set<ConstraintViolation<InterviewDTO>> violations = validator.validate(interview);
			yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
		}
	  
	  @Test
		public void testInterviewNameLength() throws Exception {
			InterviewDTO interview = MasterData.getInterviewDto();
			interview.setInterviewName("Jav");
			Set<ConstraintViolation<InterviewDTO>> violations = validator.validate(interview);
			yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
		}
	  
	  @Test
		public void testUsersSkillsLength() throws Exception {
			InterviewDTO interview = MasterData.getInterviewDto();
			interview.setUsersSkill("Jav");
			Set<ConstraintViolation<InterviewDTO>> violations = validator.validate(interview);
			yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
		}
	  
	  @Test
		public void testInterviewStatusLength() throws Exception {
			InterviewDTO interview = MasterData.getInterviewDto();
			interview.setInterviewStatus("Pass");
			Set<ConstraintViolation<InterviewDTO>> violations = validator.validate(interview);
			yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
		}
	  
	  @Test
		public void testTechnicalInterviewStatusLength() throws Exception {
			InterviewDTO interview = MasterData.getInterviewDto();
			interview.setTechnicalInterviewStatus("Succ");
			Set<ConstraintViolation<InterviewDTO>> violations = validator.validate(interview);
			yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
		}
	
	  
	  @Test
		public void testRemarksLength() throws Exception {
			InterviewDTO interview = MasterData.getInterviewDto();
			interview.setRemarks("Test");
			Set<ConstraintViolation<InterviewDTO>> violations = validator.validate(interview);
			yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
		}
}
