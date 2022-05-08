package com.spring.boot.data.Inheritance.Repos;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.data.Inheritance.Entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
