package com.spring.boot.data.TransactionalManagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.boot.data.TransactionalManagement.Services.BankAccountService;

@SpringBootTest
class TransactionalManagementApplicationTests {

	@Autowired
	BankAccountService service;
	
	@Test
	void contextLoads() {
		service.transfer(500);
	}

}
