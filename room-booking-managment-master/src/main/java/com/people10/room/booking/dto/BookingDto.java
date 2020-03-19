package com.people10.room.booking.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookingDto {

	
	private long roomId;
	private long customerId;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date startDate;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date endDate;
	private long bookingId;
	
	public BookingDto() {
	}
	
	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	
	public BookingDto(long roomId, long customerId, String startDate, String endDate) {
		super();
		this.roomId = roomId;
		this.customerId = customerId;
		try {
			this.startDate = formatter.parse(startDate);
			this.endDate = formatter.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	
	
}
