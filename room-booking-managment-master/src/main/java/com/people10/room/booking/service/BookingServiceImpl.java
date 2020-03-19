package com.people10.room.booking.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people10.room.booking.dto.BookingDto;
import com.people10.room.booking.entity.Booking;
import com.people10.room.booking.entity.Customer;
import com.people10.room.booking.entity.Room;
import com.people10.room.booking.error.BookingException;
import com.people10.room.booking.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	BookingRepository bookRepository;
	
	@Override
	public void bookingRoom(BookingDto dto) {
		
		Room room = roomService.getRoom(dto.getRoomId());
		
		if(!checkAvailability(dto.getStartDate(), dto.getEndDate(), room)) {
			logger.debug("failed condition due to dates");
			throw new BookingException("Date Range confit");
		}
		Customer cus = customerService.getCustomer(dto.getCustomerId());
		
		Booking booking = new Booking(cus, room, dto.getStartDate(), dto.getEndDate());
		
		bookRepository.save(booking);
		
	}
	
	private boolean checkAvailability(Date startDate, Date endDate, Room room) {
		
		List<Booking> bookingListForTheRoom = bookRepository.findByRoom(room);
		
		Date today = new Date();
		
		if(startDate.after(endDate) || startDate.before(today) || endDate.before(today))
			return false;
		
		Optional<Booking> conflitBooking = bookingListForTheRoom.stream().filter(i -> ((startDate.after(i.getStartDate()) && startDate.before(i.getEndDate())) 
				|| (endDate.after(i.getStartDate()) && endDate.before(i.getEndDate())))).findFirst();
		
		return conflitBooking.isPresent();
		
	}

}
