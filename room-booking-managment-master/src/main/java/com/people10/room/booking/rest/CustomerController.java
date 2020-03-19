package com.people10.room.booking.rest;

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

import com.people10.room.booking.dto.CustomerDto;
import com.people10.room.booking.entity.Customer;
import com.people10.room.booking.service.CustomerService;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	ModelMapper modelMapper;

	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerDto> registerCustomer(@RequestBody CustomerDto dto) {
		Customer customer = customerService.registerCustomer(dto);
		return new ResponseEntity<>(modelMapper.map(customer, CustomerDto.class), HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable(value = "id") Integer id) {
		Customer customer = customerService.getCustomer(id);
		return new ResponseEntity<>(modelMapper.map(customer, CustomerDto.class), HttpStatus.OK);
	}

}
