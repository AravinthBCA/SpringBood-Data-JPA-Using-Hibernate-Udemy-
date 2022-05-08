package com.spring.boot.data.Associations.Repos;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.data.Associations.Entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer , Long> {

}
