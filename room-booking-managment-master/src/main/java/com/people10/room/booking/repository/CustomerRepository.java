package com.people10.room.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.people10.room.booking.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
