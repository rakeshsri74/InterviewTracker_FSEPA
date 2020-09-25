package com.iiht.interviewtracker.exception;

import static com.iiht.utils.TestUtils.currentTest;
import static com.iiht.utils.TestUtils.exceptionTestFile;
import static com.iiht.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.iiht.interviewtracker.controller.InterviewController;
import com.iiht.interviewtracker.dto.InterviewDTO;
import com.iiht.interviewtracker.service.InterviewService;
import com.iiht.utils.MasterData;


@WebMvcTest(InterviewController.class)
@RunWith(SpringRunner.class)
public class TestInterviewException {

	@Autowired 
	private MockMvc mockMvc;
	  
	  @MockBean 
	  private InterviewService interviewService;
	  
	  @Test 
	  public void testAddInterviewValidation() throws Exception { 
		  InterviewDTO interviewdto = MasterData.getInterviewDto(); 
		  interviewdto.setInterviewName("Ja");
	  
		  when(interviewService.saveInterview(interviewdto)).thenReturn(interviewdto); 
	  
	  
		  RequestBuilder
		  	requestBuilder = MockMvcRequestBuilders.post("/interview/addInterview")
		  	.content(MasterData.asJsonString(interviewdto))
		  	.contentType(MediaType.APPLICATION_JSON) 
		  	.accept(MediaType.APPLICATION_JSON);
	  
		  MvcResult result = mockMvc.perform(requestBuilder).andReturn(); 
	  
		  System.out.println(result.getResponse().getStatus());
	  
		  yakshaAssert(currentTest(),
			   result.getResponse().getStatus() == 400? true : false,
					   exceptionTestFile); 
	  }
	  
	  @Test 
	  public void testUpdateInterviewValidation() throws Exception { 
		  InterviewDTO interviewdto = MasterData.getInterviewDto(); 
		  interviewdto.setInterviewId("1");
	  
		  when(interviewService.updateInterview(interviewdto)).thenReturn(interviewdto); 
	  
		  RequestBuilder
		  	requestBuilder = MockMvcRequestBuilders.post("/interview/updateInterview")
		  		.content(MasterData.toJson(interviewdto))
		  		.contentType(MediaType.APPLICATION_JSON) 
		  		.accept(MediaType.APPLICATION_JSON);
	  
		  MvcResult result = mockMvc.perform(requestBuilder).andReturn(); 
	  
		  System.out.println(result.getResponse().getStatus()); 
	  
		  yakshaAssert(currentTest(),
			  result.getResponse().getStatus() == 400? true :false,
					  exceptionTestFile); 
	  }
	  
	  @Test 
	  public void testDeleteInterviewValidation() throws Exception { 
		  InterviewDTO interviewdto = MasterData.getInterviewDto(); 
		  interviewdto.setInterviewId("1");
	  
		  when(interviewService.delete(interviewdto.getInterviewId())).thenReturn(interviewdto); 
	  
		  RequestBuilder
		  	requestBuilder = MockMvcRequestBuilders.delete("/interview/deleteInterview/1")
		  		.content(MasterData.toJson(interviewdto))
		  		.contentType(MediaType.APPLICATION_JSON) 
		  		.accept(MediaType.APPLICATION_JSON);
	  
		  MvcResult result = mockMvc.perform(requestBuilder).andReturn(); 
	  
		  System.out.println(result.getResponse().getStatus()); 
	  
		  yakshaAssert(currentTest(),
			  result.getResponse().getStatus() == 400? true :false,
					  exceptionTestFile); 
	  }

}
