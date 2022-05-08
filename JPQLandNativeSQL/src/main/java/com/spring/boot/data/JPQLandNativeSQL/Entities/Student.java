package com.spring.boot.data.JPQLandNativeSQL.Entities;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "fname")
	private String firstName;
	@Column(name = "lname")
	private String lastName;
	private int score;
	
}
