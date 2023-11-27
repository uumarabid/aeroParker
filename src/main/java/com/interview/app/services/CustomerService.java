package com.interview.app.services;

import org.springframework.stereotype.Service;

import com.interview.app.Dtos.CustomerDto;
import com.interview.app.interfaces.ICustomer;
import com.interview.app.models.Customer;
import com.interview.app.repositories.CustomerRepository;

@Service
public class CustomerService implements ICustomer {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setEmailAddress(customerDto.getEmailAddress().toLowerCase());
        customer.setTitle(customerDto.getTitle());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setAddressLine_1(customerDto.getAddressLine1());
        customer.setAddressLine_2(customerDto.getAddressLine2());
        customer.setCity(customerDto.getCity());
        customer.setPostcode(customerDto.getPostcode());
        customer.setPhoneNumber(customerDto.getPhoneNumber());

        customerRepository.save(customer);
    }

    @Override
    public Customer findByEmailAddress(String emailAddress) {
        return customerRepository.findByEmailAddress(emailAddress);
    }

}