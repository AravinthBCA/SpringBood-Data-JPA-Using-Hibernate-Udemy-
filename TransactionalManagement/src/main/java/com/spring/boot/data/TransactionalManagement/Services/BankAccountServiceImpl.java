package com.spring.boot.data.TransactionalManagement.Services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.data.TransactionalManagement.Entities.BankAccount;
import com.spring.boot.data.TransactionalManagement.Repos.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepository bankRepo;
	
	@Override
	@Transactional //the below method throw any exception means will be debited but not credit to 
//another account, because of using @Transactional annotation in between throw any exception it 
// rollbacked automatically
	public void transfer(int amount) {
		BankAccount aravinth = bankRepo.findById(1).get();
		aravinth.setBal(aravinth.getBal()-amount);
		bankRepo.save(aravinth);
		
		if(true) {
			throw new RuntimeException();
		}
		
		BankAccount ruban = bankRepo.findById(2).get();
		ruban.setBal(ruban.getBal()+amount);
		bankRepo.save(ruban);
	}

}
