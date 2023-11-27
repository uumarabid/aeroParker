package com.interview.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.app.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmailAddress(String emailAddress);

}