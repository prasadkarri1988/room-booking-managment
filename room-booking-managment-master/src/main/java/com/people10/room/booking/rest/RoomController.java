package com.people10.room.booking.rest;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.people10.room.booking.dto.RoomDto;
import com.people10.room.booking.entity.Room;
import com.people10.room.booking.service.RoomService;

@RestController
@RequestMapping("/api/room/")
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	ModelMapper  modelMapper;
	
	@PostMapping(value="/register", consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoomDto> registerRoom(@Valid @RequestBody RoomDto roomDto) {
		Room room = roomService.registerRoom(roomDto);
		 return new ResponseEntity<>(modelMapper.map(room, RoomDto.class),HttpStatus.CREATED);
	}

	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoomDto> getRoom(@PathVariable(value = "id") Integer id) {
		 Room room = roomService.getRoom(id);
		 return new ResponseEntity<>(modelMapper.map(room, RoomDto.class), HttpStatus.OK);
	}

}
