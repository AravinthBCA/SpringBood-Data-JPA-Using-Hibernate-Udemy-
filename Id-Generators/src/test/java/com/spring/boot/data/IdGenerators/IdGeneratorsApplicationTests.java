package com.spring.boot.data.IdGenerators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.boot.data.IdGenerators.Entities.Employee;
import com.spring.boot.data.IdGenerators.Repos.EmployeeRepository;

@SpringBootTest
class IdGeneratorsApplicationTests {

	@Autowired
	EmployeeRepository employeeRepo;
	
	@Test
	void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setName("John");
		employeeRepo.save(employee);
	}

}
