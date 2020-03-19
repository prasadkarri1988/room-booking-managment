package com.people10.room.booking.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingId;

	@ManyToOne
	@JoinColumn(name ="customerId", nullable=false)
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name ="roomId", nullable=false)
	private Room room;
	
	private Date startDate;
	private Date endDate;
	
	public Booking() {
	}
	
	public Booking(Customer customer, Room room, Date startDate, Date endDate) {
		super();
		this.customer = customer;
		this.room = room;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
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
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customerId=" + customer + ", roomId=" + room + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
	
	
}
