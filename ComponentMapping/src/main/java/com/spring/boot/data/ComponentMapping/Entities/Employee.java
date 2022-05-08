package com.spring.boot.data.ComponentMapping.Entities;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employee_1")
public class Employee {
	
	@Id
	private int id;
	private String name;
	@Embedded
	private Address address;
	

}
