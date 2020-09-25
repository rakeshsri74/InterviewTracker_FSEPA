package com.iiht.interviewtracker.functional;

import static com.iiht.utils.TestUtils.asJsonString;
import static com.iiht.utils.TestUtils.businessTestFile;
import static com.iiht.utils.TestUtils.currentTest;
import static com.iiht.utils.TestUtils.yakshaAssert;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.iiht.interviewtracker.controller.InterviewController;
import com.iiht.interviewtracker.dto.InterviewDTO;
import com.iiht.interviewtracker.dto.UserDTO;
import com.iiht.interviewtracker.service.InterviewService;
import com.iiht.utils.MasterData;

@WebMvcTest(InterviewController.class)
@RunWith(SpringRunner.class)
public class InterviewControllerTest {
	
	@Autowired 
	private MockMvc mockMvc;
	  
	@MockBean 
	private InterviewService interviewService;
	
	@Test
	void testAddInterview() throws Exception {
		InterviewDTO interviewdto = MasterData.getInterviewDto();
		Mockito.when(interviewService.saveInterview(interviewdto))
		.thenReturn(interviewdto);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/interview/addInterview")
				.content(MasterData.asJsonString(interviewdto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getContentAsString());
		System.out.println(interviewdto);
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(asJsonString(interviewdto))? true : false,
				businessTestFile);
		
	}
	
	@Test
	void testAddInterviewBDD() throws Exception {
		final int count[] = new int[1];
		InterviewDTO interviewdto = MasterData.getInterviewDto();
		Mockito.when(interviewService.saveInterview(interviewdto)).then(new Answer<InterviewDTO>() {

			@Override
			public InterviewDTO answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("Called");
				count[0]++;
				return interviewdto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/interview/addInterview")
				.content(MasterData.asJsonString(interviewdto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(count[0]);
	
		yakshaAssert(currentTest(),count[0] == 1? true : false,businessTestFile);
				
	}
	
	@Test
	void testAddAttendee() throws Exception {
		InterviewDTO interviewdto = MasterData.getInterviewDto();
		UserDTO userdto = MasterData.getUserDto();
		Mockito.when(interviewService.addAttendee(interviewdto.getInterviewId(),userdto.getUserId()))
		.thenReturn(interviewdto);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/interview/addAttendee/1/1")
				.content(MasterData.asJsonString(interviewdto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getContentAsString());
		System.out.println(interviewdto);
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(asJsonString(interviewdto))? true : false,
				businessTestFile);
		
	}
	
	@Test
	void testAddAttendeeBDD() throws Exception {
		final int count[] = new int[1];
		InterviewDTO interviewdto = MasterData.getInterviewDto();
		UserDTO userdto = MasterData.getUserDto();
		Mockito.when(interviewService.addAttendee(interviewdto.getInterviewId(),userdto.getUserId())).then(new Answer<InterviewDTO>() {

			@Override
			public InterviewDTO answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("Called");
				count[0]++;
				return interviewdto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/interview/addAttendee/1/1")
				.content(MasterData.asJsonString(interviewdto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(count[0]);
	
		yakshaAssert(currentTest(),count[0] == 1? true : false,businessTestFile);
				
	}
	
	@Test
	void testViewAllInterviews() throws Exception {
		List<InterviewDTO> list = new ArrayList<InterviewDTO>();
		list.add(MasterData.getInterviewDto());
		Mockito.when(interviewService.findAll()).thenReturn(list);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/interview/viewAllInterviews")
				.content(MasterData.asJsonString(MasterData.getInterviewDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		System.out.println(result.getResponse().getContentAsString());
		System.out.println(asJsonString(list));
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contentEquals(asJsonString(list))? "true" : "false"),	businessTestFile);
		
	}
	
	@Test
	void testViewAllInterviewsBDD() throws Exception {
		final int count[] = new int[1];
		List<InterviewDTO> list = new ArrayList<InterviewDTO>();
		list.add(MasterData.getInterviewDto());
		Mockito.when(interviewService.findAll()).then(new Answer<List<InterviewDTO>>() {

			@Override
			public List<InterviewDTO> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("Called");
				count[0]++;
				return list;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/interview/viewAllInterviews")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(count[0]);
	
		yakshaAssert(currentTest(),count[0] == 1? true : false,businessTestFile);
				
	}

	@Test
	public void testUpdateInterviews() throws Exception{
		InterviewDTO interviewdto = MasterData.getInterviewDto();
		Mockito.when(interviewService.updateInterview(interviewdto)).thenReturn(interviewdto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/interview/updateInterview")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getContentAsString().toString());
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contentEquals(asJsonString(interviewdto))? "true" : "false"),	businessTestFile);
	}
	
	@Test
	void testUpdateInterviewsBDD() throws Exception {
		final int count[] = new int[1];
		InterviewDTO interviewdto = MasterData.getInterviewDto();
		Mockito.when(interviewService.updateInterview(interviewdto)).then(new Answer<InterviewDTO>() {

			@Override
			public InterviewDTO answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("Called");
				count[0]++;
				return interviewdto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/interview/updateInterview")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(count[0]);
	
		yakshaAssert(currentTest(),count[0] == 1? true : false,businessTestFile);
				
	}
	
	@Test
	void testDeleteInterview() throws Exception{
		InterviewDTO interviewdto = MasterData.getInterviewDto();
		Mockito.when(interviewService.delete(interviewdto.getInterviewId()))
		.thenReturn(interviewdto);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/interview/deleteInterview/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(asJsonString(interviewdto))? true : false,businessTestFile);
		
	}

	@Test
	void testDeleteInterviewBDD() throws Exception {
		final int count[] = new int[1];
		InterviewDTO interviewdto = MasterData.getInterviewDto();
		Mockito.when(interviewService.delete(interviewdto.getInterviewId())).then(new Answer<InterviewDTO>() {

			@Override
			public InterviewDTO answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("Called");
				count[0]++;
				return MasterData.getInterviewDto();
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/interview/deleteInterview/1")
				.content(MasterData.asJsonString(interviewdto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(count[0]);
	
		yakshaAssert(currentTest(),count[0] == 1? true : false,businessTestFile);
				
	}

	@Test
	void testFindByInterviewName() throws Exception {
		InterviewDTO interviewDTO = MasterData.getInterviewDto();
		interviewDTO.setInterviewName("Java");
		
		Mockito.when(interviewService.findInterviewByName("Java")).thenReturn(interviewDTO);
		
		MvcResult result = mockMvc.perform(get("/interview/search/interviewName/Java").contentType(MediaType.APPLICATION_JSON)).andReturn();
  		yakshaAssert(currentTest(), 
  				result.getResponse().getContentAsString().contentEquals(asJsonString(interviewDTO))? true : false,
  				businessTestFile);
		
	}
	
	@Test
	void testFindByInterviewNameBDD() throws Exception {
		final int count[] = new int[1];
		InterviewDTO interview1 = MasterData.getInterviewDto();
		interview1.setInterviewName("Java");
		Mockito.when(interviewService.findInterviewByName("Java")).then(new Answer<InterviewDTO>() {

			@Override
			public InterviewDTO answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("Called");
				count[0]++;
				return interview1;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/interview/search/interviewName/Java")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(count[0]);
	
		yakshaAssert(currentTest(),count[0] == 1? true : false,businessTestFile);
				
	}
	@Test
	void testShowInterview() throws Exception {
		InterviewDTO interviewDTO = MasterData.getInterviewDto();
		interviewDTO.setInterviewId("1");
		
		Mockito.when(interviewService.showInterview(interviewDTO.getInterviewId())).thenReturn(interviewDTO);
		
		MvcResult result = mockMvc.perform(get("/interview/showInterview/1").contentType(MediaType.APPLICATION_JSON)).andReturn();
  		yakshaAssert(currentTest(), 
  				result.getResponse().getContentAsString().contentEquals(asJsonString(interviewDTO))? true : false,
  				businessTestFile);
		
	}
	
	@Test
	void testShowInterviewBDD() throws Exception {
		final int count[] = new int[1];
		InterviewDTO interview1 = MasterData.getInterviewDto();
		interview1.setInterviewId("1");
		Mockito.when(interviewService.showInterview(interview1.getInterviewId())).then(new Answer<InterviewDTO>() {

			@Override
			public InterviewDTO answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("Called");
				count[0]++;
				return interview1;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/interview/interview/showInterview/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(count[0]);
	
		yakshaAssert(currentTest(),count[0] == 1? true : false,businessTestFile);
				
	}

	@Test
	void testFindByInterviewerName() throws Exception {
		InterviewDTO interviewDTO = MasterData.getInterviewDto();
		UserDTO user = new UserDTO();
		
		user.setUserId("1");
		user.setFirstName("Rakesh");
		user.setLastName("Srivastava");
		user.setReportingTo("Sandeep");
		user.setUserStatus("Active");
		user.setUserType("Admin");
		user.setMobile("7612398345");
		user.setEmail("yaksha@iiht.com");
		
		interviewDTO.setInterviewer(user);
		
		Mockito.when(interviewService.findByInterviewerName("Satyam")).thenReturn(interviewDTO);
		
		MvcResult result = mockMvc.perform(get("/interview/search/interviewerName/Satyam").contentType(MediaType.APPLICATION_JSON)).andReturn();
  		yakshaAssert(currentTest(), 
  				result.getResponse().getContentAsString().contentEquals(asJsonString(interviewDTO))? true : false,
  				businessTestFile);
		
	}
	@Test
	void testFindByInterviewerNameBDD() throws Exception {
		final int count[] = new int[1];
		UserDTO userDTO = MasterData.getUserDto();
		InterviewDTO interview1 = MasterData.getInterviewDto();
		InterviewDTO interview2 = MasterData.getInterviewDto();
		interview1.setInterviewer(userDTO);
		interview2.setInterviewer(userDTO);
		List<InterviewDTO> list = new ArrayList();
		list.add(interview1);
		list.add(interview2);
		Mockito.when(interviewService.findInterviewByName("Satyam")).then(new Answer<List<InterviewDTO>>() {

			@Override
			public List<InterviewDTO> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("Called");
				count[0]++;
				return list;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/interview/search/interviewerName/Satyam")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(count[0]);
	
		yakshaAssert(currentTest(),count[0] == 1? true : false,businessTestFile);
				
	}

	@Test
	void testCountNoOfInterviews() throws Exception {
		Integer i = interviewService.countInterviews();
		Mockito.when(interviewService.countInterviews())
		.thenReturn(i);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/interview/count")
				.content(MasterData.asJsonString(i))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getContentAsString());
		System.out.println(i);
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(asJsonString(i))? true : false,
				businessTestFile);
		
	}
	
	@Test
	void testCountNoOfInterviewsBDD() throws Exception {
		final int count[] = new int[1];
		Integer i = interviewService.countInterviews();
		Mockito.when(interviewService.countInterviews()).then(new Answer<Integer>() {

			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("Called");
				count[0]++;
				return i;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/interview/count")
				.content(MasterData.asJsonString(i))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(count[0]);
	
		yakshaAssert(currentTest(),count[0] == 1? true : false,businessTestFile);
				
	}


}
