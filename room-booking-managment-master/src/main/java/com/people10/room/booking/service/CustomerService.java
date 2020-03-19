package com.people10.room.booking.service;

import org.springframework.stereotype.Service;

import com.people10.room.booking.dto.CustomerDto;
import com.people10.room.booking.entity.Customer;

@Service
public interface CustomerService {
	
	Customer registerCustomer(CustomerDto dto);
	Customer getCustomer(long id);
	
}
