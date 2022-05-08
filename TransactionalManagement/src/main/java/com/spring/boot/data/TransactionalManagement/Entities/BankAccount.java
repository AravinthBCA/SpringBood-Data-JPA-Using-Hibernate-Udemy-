package com.spring.boot.data.TransactionalManagement.Entities;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="bankaccount")
public class BankAccount {
	
	@Id
	private int accno;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	private int bal;
	
}
