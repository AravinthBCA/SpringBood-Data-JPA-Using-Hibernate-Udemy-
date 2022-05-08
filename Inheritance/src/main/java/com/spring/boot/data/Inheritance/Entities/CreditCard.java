package com.spring.boot.data.Inheritance.Entities;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
//above two annotations is enough for table_per_class
//@DiscriminatorValue("cc") // single table strategy
@Table(name = "card_1")
//@PrimaryKeyJoinColumn(name = "id") //optional for joined strategy
public class CreditCard extends Payment{

	private String cardNumber;
	
}
