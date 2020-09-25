package com.iiht.interviewtracker.functional;

import static com.iiht.utils.TestUtils.asJsonString;
import static com.iiht.utils.TestUtils.businessTestFile;
import static com.iiht.utils.TestUtils.currentTest;
import static com.iiht.utils.TestUtils.yakshaAssert;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
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
public class UserControllerTest {

	@Autowired 
	private MockMvc mockMvc;
	  
	@MockBean 
	private UserService userService;
	
	@Test
	void testAddUser() throws Exception {
		UserDTO userdto = MasterData.getUserDto();
		Mockito.when(userService.saveUser(userdto))
		.thenReturn(userdto);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/addUser")
				.content(MasterData.asJsonString(userdto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getContentAsString());
		System.out.println(userdto);
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(asJsonString(userdto))? true : false,
				businessTestFile);
		
	}
	
	@Test
	void testAddUserBDD() throws Exception {
		final int count[] = new int[1];
		UserDTO userdto = MasterData.getUserDto();
		Mockito.when(userService.saveUser(userdto)).then(new Answer<UserDTO>() {

			@Override
			public UserDTO answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("Called");
				count[0]++;
				return userdto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/addUser")
				.content(MasterData.asJsonString(userdto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(count[0]);
	
		yakshaAssert(currentTest(),count[0] == 1? true : false,businessTestFile);
				
	}
	
	@Test
	void testViewAllUsers() throws Exception {
		List<UserDTO> list = new ArrayList<UserDTO>();
		list.add(MasterData.getUserDto());
		Mockito.when(userService.findAll()).thenReturn(list);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/viewAllUsers")
				.content(MasterData.asJsonString(MasterData.getUserDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		System.out.println(result.getResponse().getContentAsString());
		System.out.println(asJsonString(list));
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contentEquals(asJsonString(list))? "true" : "false"),	businessTestFile);
		
	}
	
	@Test
	void testViewAllUsersBDD() throws Exception {
		final int count[] = new int[1];
		List<UserDTO> list = new ArrayList<UserDTO>();
		list.add(MasterData.getUserDto());
		Mockito.when(userService.findAll()).then(new Answer<List<UserDTO>>() {

			@Override
			public List<UserDTO> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("Called");
				count[0]++;
				return list;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/viewAllUsers")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(count[0]);
	
		yakshaAssert(currentTest(),count[0] == 1? true : false,businessTestFile);
				
	}

	@Test
	public void testUpdateUser() throws Exception{
		UserDTO userdto = MasterData.getUserDto();
		Mockito.when(userService.updateUser(userdto)).thenReturn(userdto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/user/updateUser")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getContentAsString().toString());
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contentEquals(asJsonString(userdto))? "true" : "false"),	businessTestFile);
	}
	
	@Test
	void testUpdateUserBDD() throws Exception {
		final int count[] = new int[1];
		UserDTO userdto = MasterData.getUserDto();
		Mockito.when(userService.updateUser(userdto)).then(new Answer<UserDTO>() {

			@Override
			public UserDTO answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("Called");
				count[0]++;
				return userdto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/user/updateUser")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(count[0]);
	
		yakshaAssert(currentTest(),count[0] == 1? true : false,businessTestFile);
				
	}
	
	@Test
	void testDeleteUser() throws Exception{
		UserDTO userdto = MasterData.getUserDto();
		Mockito.when(userService.delete(userdto.getUserId()))
		.thenReturn(userdto);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/user/deleteUser/Rakesh")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(asJsonString(userdto))? true : false,businessTestFile);
		
	}

	@Test
	void testDeleteUserBDD() throws Exception {
		final int count[] = new int[1];
		UserDTO userdto = MasterData.getUserDto();
		Mockito.when(userService.delete(userdto.getUserId())).then(new Answer<UserDTO>() {

			@Override
			public UserDTO answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("Called");
				count[0]++;
				return MasterData.getUserDto();
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/user/deleteUser/Rakesh")
				.content(MasterData.asJsonString(userdto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(count[0]);
	
		yakshaAssert(currentTest(),count[0] == 1? true : false,businessTestFile);
				
	}
	

}
