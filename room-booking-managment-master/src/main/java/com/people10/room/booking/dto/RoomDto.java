package com.people10.room.booking.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RoomDto {

	@Pattern(regexp="Q|M",message="Only Q or M is allowed") 
	private String roomType;
	@NotNull(message = "rent should be numaric and not empty ")
	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer=3, fraction=2)
	private BigDecimal rent;
	private long roomId;
	
	public RoomDto() {
	}
	
	
	public RoomDto(String roomType, BigDecimal rent) {
		super();
		this.roomType = roomType;
		this.rent = rent;
	}


	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public BigDecimal getRent() {
		return rent;
	}
	public void setRent(BigDecimal rent) {
		this.rent = rent;
	}


	public long getRoomId() {
		return roomId;
	}


	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	
	
}
