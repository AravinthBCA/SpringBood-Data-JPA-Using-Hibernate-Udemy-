package com.spring.boot.data.Associations;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.data.Associations.Entities.Customer;
import com.spring.boot.data.Associations.Entities.PhoneNumber;
import com.spring.boot.data.Associations.MTM.Entities.Programmer;
import com.spring.boot.data.Associations.MTM.Entities.Project;
import com.spring.boot.data.Associations.OTO.Entities.License;
import com.spring.boot.data.Associations.OTO.Entities.Person;
import com.spring.boot.data.Associations.Repos.CustomerRepository;
import com.spring.boot.data.Associations.Repos.LicenseRepository;
import com.spring.boot.data.Associations.Repos.ProgrammerRepository;

import lombok.Data;

@SpringBootTest
public class AssociationsApplicationTests {

	@Autowired
	CustomerRepository repository;

	@Autowired
	ProgrammerRepository programmerRepository;

	@Autowired
	LicenseRepository licenseRepository;

//	@Test
	public void contextLoads() {
	}

//	@Test
	public void testCreateCustomer() {

		Customer customer = new Customer();
		customer.setName("John");

		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("1234567890");
		ph1.setType("cell");

		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("0987654321");
		ph2.setType("home");

		customer.addPhoneNumber(ph1);
		customer.addPhoneNumber(ph2);

		repository.save(customer);
	}

//	@Test
	@Transactional
	public void testLoadCustomer() {
		Customer customer = repository.findById(22L).get();
		System.out.println(customer.getName());

		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(number -> System.out.println(number.getNumber()));

	}

//	@Test
	public void testUpdateCustomer() {
		Customer customer = repository.findById(22L).get();
		customer.setName("John Bush");

		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(number -> number.setType("cell"));

		repository.save(customer);

	}

//	@Test
	public void testDelete() {
		repository.deleteById(22l);
	}

//	@Test
	public void testmtomCreateProgrammer() {
		Programmer programmer = new Programmer();
		programmer.setName("John");
		programmer.setSal(10000);

		HashSet<Project> projects = new HashSet<Project>();
		Project project = new Project();
		project.setName("Hibernate Project");
		projects.add(project);

		programmer.setProjects(projects);

		programmerRepository.save(programmer);
	}

//	@Test
//	@Transactional
	public void testmtomFindProgrammer() {
		Programmer programmer = programmerRepository.findById(37).get();
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}

//	@Test
	public void testOneToOneCreateLicense() {
		License license = new License();
		license.setType("CAR");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());

		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("Clinton");
		person.setAge(35);

		license.setPerson(person);

		licenseRepository.save(license);
	}

}
