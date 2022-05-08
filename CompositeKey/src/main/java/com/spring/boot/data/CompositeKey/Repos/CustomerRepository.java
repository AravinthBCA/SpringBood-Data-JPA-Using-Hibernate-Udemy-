package com.spring.boot.data.CompositeKey.Repos;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.data.CompositeKey.Entities.Customer;
import com.spring.boot.data.CompositeKey.Entities.CustomerId;

public interface CustomerRepository extends CrudRepository<Customer, CustomerId> {

}
