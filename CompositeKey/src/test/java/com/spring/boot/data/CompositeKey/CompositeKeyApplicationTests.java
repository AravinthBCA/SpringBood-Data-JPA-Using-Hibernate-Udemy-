package com.spring.boot.data.CompositeKey;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.boot.data.CompositeKey.Entities.Customer;
import com.spring.boot.data.CompositeKey.Entities.CustomerId;
import com.spring.boot.data.CompositeKey.Repos.CustomerRepository;

@SpringBootTest
class CompositeKeyApplicationTests {

	@Autowired
	CustomerRepository customerRepo;
	
	@Test
	void testSaveCustomer() {
		Customer customer = new Customer();
		
		CustomerId customerId = new CustomerId();
		customerId.setId(1234);
		customerId.setEmail("test@gmail.com");
		customer.setId(customerId);
		customer.setName("test");
		customerRepo.save(customer);
	}

}
