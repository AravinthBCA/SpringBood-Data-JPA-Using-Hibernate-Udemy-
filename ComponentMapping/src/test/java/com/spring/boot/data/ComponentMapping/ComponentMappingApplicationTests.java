package com.spring.boot.data.ComponentMapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.boot.data.ComponentMapping.Entities.Address;
import com.spring.boot.data.ComponentMapping.Entities.Employee;
import com.spring.boot.data.ComponentMapping.Repos.EmployeeRepository;

@SpringBootTest
class ComponentMappingApplicationTests {

	@Autowired
	EmployeeRepository employeeRepo;
	
	@Test
	void contextLoads() {
		Employee emp = new Employee();
		emp.setId(123);
		emp.setName("Aravinth");
		Address add = new Address();
		add.setCity("Thiruppanjili");
		add.setCountry("India");
		add.setZipcode("621005");
		add.setState("Tamil Nadu");
		add.setStreetaddress("North Street");
		emp.setAddress(add);
		employeeRepo.save(emp);
	}
	
	@Test
	public void testCreate() {
		
	}

}
