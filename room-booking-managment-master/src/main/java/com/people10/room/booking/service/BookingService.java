package com.people10.room.booking.service;

import org.springframework.stereotype.Service;

import com.people10.room.booking.dto.BookingDto;

@Service
public interface BookingService {

	void bookingRoom(BookingDto dto);
}
