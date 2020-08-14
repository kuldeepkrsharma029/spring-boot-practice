package com.sample.app.service.impl;

import com.sample.app.common.emums.ErrorCode;
import com.sample.app.exception.CustomerResourceNotFoundException;
import com.sample.app.exception.ResourceAlreadyExistException;
import com.sample.app.model.Customer;
import com.sample.app.repository.CustomerRepository;
import com.sample.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findCustomerById(String id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()) {
            return customerOptional.get();
        }
        throw new CustomerResourceNotFoundException("Customer not found by id : " + id, ErrorCode.CR100);
    }

    @Override
    public Customer save(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findByFirstName(customer.getFirstName());
        if(customerOptional.isPresent()) {
            throw new ResourceAlreadyExistException("Customer already exist with firsName : " + customer.getFirstName(), ErrorCode.CR200);
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerByName(String name) {
        Optional<Customer> customerOptional = customerRepository.findByFirstName(name);
        if(customerOptional.isPresent()) {
            return customerOptional.get();
        }
        throw new CustomerResourceNotFoundException("Customer not found by name : " + name, ErrorCode.CR100);
    }
}
