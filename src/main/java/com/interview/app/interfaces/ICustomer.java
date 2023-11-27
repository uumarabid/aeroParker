package com.interview.app.interfaces;

import java.util.List;

import com.interview.app.Dtos.CustomerDto;
import com.interview.app.models.Customer;

public interface ICustomer {
    void saveCustomer(CustomerDto customerDto);

    Customer findByEmailAddress(String emailAddress);

}