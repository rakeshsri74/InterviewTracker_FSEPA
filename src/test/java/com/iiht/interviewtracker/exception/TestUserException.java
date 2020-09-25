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

import com.iiht.interviewtracker.controller.UserController;
import com.iiht.interviewtracker.dto.UserDTO;
import com.iiht.interviewtracker.service.UserService;
import com.iiht.utils.MasterData;

@WebMvcTest(UserController.class)
@RunWith(SpringRunner.class)
public class TestUserException {
	
	@Autowired 
	private MockMvc mockMvc;
	  
	  @MockBean 
	  private UserService userService;
	  
	  @Test 
	  public void testAddUserValidation() throws Exception { 
		  UserDTO userdto = MasterData.getUserDto(); 
		  userdto.setFirstName("Ra");
	  
		  when(userService.saveUser(userdto)).thenReturn(userdto); 
	  
	  
		  RequestBuilder
		  	requestBuilder = MockMvcRequestBuilders.post("/user/addUser")
		  	.content(MasterData.asJsonString(userdto))
		  	.contentType(MediaType.APPLICATION_JSON) 
		  	.accept(MediaType.APPLICATION_JSON);
	  
		  MvcResult result = mockMvc.perform(requestBuilder).andReturn(); 
	  
		  System.out.println(result.getResponse().getStatus());
	  
		  yakshaAssert(currentTest(),
			   result.getResponse().getStatus() == 400? true : false,
					   exceptionTestFile); 
	  }
	  
	  @Test 
	  public void testUpdateUserValidation() throws Exception { 
		  UserDTO userdto = MasterData.getUserDto(); 
		  userdto.setUserId("1001");
	  
		  when(userService.updateUser(userdto)).thenReturn(userdto); 
	  
		  RequestBuilder
		  	requestBuilder = MockMvcRequestBuilders.post("/user/updateUser")
		  		.content(MasterData.toJson(userdto))
		  		.contentType(MediaType.APPLICATION_JSON) 
		  		.accept(MediaType.APPLICATION_JSON);
	  
		  MvcResult result = mockMvc.perform(requestBuilder).andReturn(); 
	  
		  System.out.println(result.getResponse().getStatus()); 
	  
	  yakshaAssert(currentTest(),
			  result.getResponse().getStatus() == 400? true :false,
					  exceptionTestFile); 
	  }
	  
	  @Test 
	  public void testDeleteUserValidation() throws Exception { 
		  UserDTO userdto = MasterData.getUserDto(); 
		  userdto.setUserId("1001");
	  
		  when(userService.delete(userdto.getUserId())).thenReturn(userdto); 
	  
		  RequestBuilder
		  	requestBuilder = MockMvcRequestBuilders.delete("/user/deleteUser/1")
		  		.content(MasterData.toJson(userdto))
		  		.contentType(MediaType.APPLICATION_JSON) 
		  		.accept(MediaType.APPLICATION_JSON);
	  
		  MvcResult result = mockMvc.perform(requestBuilder).andReturn(); 
	  
		  System.out.println(result.getResponse().getStatus()); 
	  
	  yakshaAssert(currentTest(),
			  result.getResponse().getStatus() == 400? true :false,
					  exceptionTestFile); 
	  }

}
