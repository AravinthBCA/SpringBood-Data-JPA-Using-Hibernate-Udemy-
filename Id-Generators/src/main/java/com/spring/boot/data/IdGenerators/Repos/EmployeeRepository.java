package com.spring.boot.data.IdGenerators.Repos;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.data.IdGenerators.Entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{

}
