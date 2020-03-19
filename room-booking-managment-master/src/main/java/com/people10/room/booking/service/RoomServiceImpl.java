package com.people10.room.booking.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people10.room.booking.dto.RoomDto;
import com.people10.room.booking.entity.Room;
import com.people10.room.booking.error.NoRecordsException;
import com.people10.room.booking.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	RoomRepository roomRepository;

	@Override
	public Room registerRoom(RoomDto roomDto) {
		Room room = new Room(roomDto.getRoomType().charAt(0), roomDto.getRent());
		return roomRepository.save(room);
	}

	@Override
	public Room getRoom(long id) {

		return roomRepository.findById(id).orElseThrow(() -> new NoRecordsException("No Room for the given ID"));
	
	}

}
