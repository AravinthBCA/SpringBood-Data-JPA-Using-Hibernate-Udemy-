package com.spring.boot.data.DatingApi.Entities;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"interest"}) 
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String password;
	private int age;
	private String email;
	private String phoneNumber;
	private String gender;
	private String city;
	private String country;
	
	@OneToMany(mappedBy="userAccount",cascade = CascadeType.ALL)
	private List<Interest> interest;
	
}
