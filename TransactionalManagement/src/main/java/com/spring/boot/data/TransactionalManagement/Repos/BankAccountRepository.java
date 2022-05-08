package com.spring.boot.data.TransactionalManagement.Repos;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.data.TransactionalManagement.Entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
