package com.spring.boot.data.ComponentMapping.Repos;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.data.ComponentMapping.Entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
