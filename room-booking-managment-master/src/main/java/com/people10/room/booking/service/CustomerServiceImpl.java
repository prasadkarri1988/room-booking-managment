package com.people10.room.booking.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people10.room.booking.dto.CustomerDto;
import com.people10.room.booking.entity.Customer;
import com.people10.room.booking.error.NoRecordsException;
import com.people10.room.booking.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer registerCustomer(CustomerDto dto) {
		Customer cus = modelMapper.map(dto, Customer.class);
		cus = customerRepository.save(cus);
		return cus;
	}

	@Override
	public Customer getCustomer(long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new NoRecordsException("No Customer for the given ID"));
	}

}
