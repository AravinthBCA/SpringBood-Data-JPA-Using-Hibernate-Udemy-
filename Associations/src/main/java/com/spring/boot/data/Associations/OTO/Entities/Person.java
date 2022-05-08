package com.spring.boot.data.Associations.OTO.Entities;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "first_name")
	private String firstName;
	@Column (name = "last_name")
	private String lastName;
	private int age;
	@OneToOne(mappedBy = "person")
	private License license;
	
}
