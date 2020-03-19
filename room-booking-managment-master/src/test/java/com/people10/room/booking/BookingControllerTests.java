package com.people10.room.booking;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
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
import com.people10.room.booking.dto.BookingDto;
import com.people10.room.booking.dto.CustomerDto;
import com.people10.room.booking.dto.RoomDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	public BookingControllerTests() {
	}

	@Test
	public void test_booking() throws Exception {
		MvcResult roomResult = mockMvc
				.perform(post("/api/room/register").contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(mapper.writeValueAsBytes(new RoomDto("Q", new BigDecimal(100)))))
				.andExpect(status().isCreated()).andReturn();

		MvcResult customerResult = mockMvc
				.perform(
						post("/api/customer/register").contentType(MediaType.APPLICATION_JSON_VALUE)
								.content(mapper.writeValueAsBytes(new CustomerDto("Naresh", "Thota", new Date(),
										"nareshthotadev@gmail.com", "password"))))
				.andExpect(status().isCreated()).andReturn();

		final long roomId = mapper.readTree(roomResult.getResponse().getContentAsString()).findValue("roomId")
				.asLong();

		final long customerId = mapper.readTree(customerResult.getResponse().getContentAsString())
				.findValue("customerId").asLong();

		mockMvc.perform(post("/api/booking/").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(mapper.writeValueAsBytes(
						new BookingDto( roomId,customerId,"20-03-2020", "27-03-2020"))))
				.andExpect(status().isCreated()).andReturn();

	}

}
