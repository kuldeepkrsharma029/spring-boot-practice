package com.sample.app.resource;

import com.sample.app.model.Customer;
import com.sample.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(customerService.findCustomerById(id));
    }

    @GetMapping(path = "/customer/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> findByName(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(customerService.findCustomerByName(name));
    }

    @PostMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok().body(customerService.save(customer));
    }

}
