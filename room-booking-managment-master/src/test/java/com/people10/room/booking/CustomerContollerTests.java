package com.people10.room.booking;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.people10.room.booking.dto.CustomerDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerContollerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	public CustomerContollerTests() {

	}
	
	@Test
	public void test_room_register() throws Exception {
		MvcResult result = mockMvc
				.perform(post("/api/customer/register").contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(mapper.writeValueAsBytes(new CustomerDto("Naresh","Thota",new Date(),"nareshthotadev@gmail.com","password"))))
				.andExpect(status().isCreated()).andReturn();

		final long customerId = mapper.readTree(result.getResponse().getContentAsString()).findValue("customerId").asLong();

		mockMvc.perform(get("/api/customer/" + customerId)).andExpect(status().isOk()).andReturn();

	}
	
}
