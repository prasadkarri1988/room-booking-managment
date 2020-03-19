package com.people10.room.booking.service;

import org.springframework.stereotype.Service;

import com.people10.room.booking.dto.RoomDto;
import com.people10.room.booking.entity.Room;

@Service
public interface RoomService {
	
	Room registerRoom(RoomDto room);
	Room getRoom(long id);

}
