package com.people10.room.booking.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerDto {

	private String firstName;
	private String lastName;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dob;
	private String email;
	private String password;
	private long customerId;
	
	public CustomerDto() {
	}
	
	public CustomerDto(String firstName, String lastName, Date dob, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.password = password;
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	public long getCustomerId() {
		return customerId;
	}



	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	
}
