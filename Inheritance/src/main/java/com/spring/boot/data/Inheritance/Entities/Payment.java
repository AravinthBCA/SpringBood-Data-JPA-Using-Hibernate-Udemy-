package com.spring.boot.data.Inheritance.Entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "payment_1") // this for joined strategy 
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {

	@Id
	private int id;
	private double amount;
	
}
