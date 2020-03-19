package com.people10.room.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.people10.room.booking.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
