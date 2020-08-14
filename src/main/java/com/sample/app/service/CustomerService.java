package com.sample.app.service;

import com.sample.app.model.Customer;

public interface CustomerService {

    Customer findCustomerById(String id);

    Customer save(Customer customer);

    Customer findCustomerByName(String name);
}
