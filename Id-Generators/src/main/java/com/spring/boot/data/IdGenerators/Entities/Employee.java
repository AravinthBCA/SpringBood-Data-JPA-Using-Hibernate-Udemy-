package com.spring.boot.data.IdGenerators.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class Employee {

//	@TableGenerator(name="employee_gen",table="id_gen",
//			pkColumnName="gen_name",valueColumnName="gen_val",allocationSize=100)
//	below two line for custom id generator
	@GenericGenerator(name="emp_id",strategy="com.spring.boot.data.IdGenerators.CustomRandomIdGenerator")
	@GeneratedValue(generator = "emp_id")
	@Id
//	@GeneratedValue(strategy=GenerationType.TABLE,generator="employee_gen")
	private Long id;
	private String name;
	
}
