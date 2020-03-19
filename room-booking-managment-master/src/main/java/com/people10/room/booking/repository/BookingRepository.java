package com.people10.room.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.people10.room.booking.entity.Booking;
import com.people10.room.booking.entity.Room;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	List<Booking> findByRoom(Room room);

}
