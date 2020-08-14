package com.sample.app.repository;

import com.sample.app.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {

  public Optional<Customer> findById(String id);
  public Optional<Customer> findByFirstName(String firstName);
  public List<Customer> findByLastName(String lastName);

}