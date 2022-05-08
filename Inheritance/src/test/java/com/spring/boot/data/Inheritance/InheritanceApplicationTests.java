package com.spring.boot.data.Inheritance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.boot.data.Inheritance.Entities.Check;
import com.spring.boot.data.Inheritance.Entities.CreditCard;
import com.spring.boot.data.Inheritance.Entities.Payment;
import com.spring.boot.data.Inheritance.Repos.PaymentRepository;

@SpringBootTest
class InheritanceApplicationTests {

	@Autowired
	PaymentRepository paymentRepo;
	
	@Test
	void testCreaditCard() {
		CreditCard cc = new CreditCard();
		cc.setId(3);
		cc.setAmount(2000);
		cc.setCardNumber("2345");
		paymentRepo.save(cc);
	}
	
	@Test
	void testCheck() {
		Check ch = new Check();
		ch.setId(4);
		ch.setAmount(3000);
		ch.setCheckNumber("1345");
		paymentRepo.save(ch);
	}

}
