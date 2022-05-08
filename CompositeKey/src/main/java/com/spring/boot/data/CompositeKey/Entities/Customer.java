package com.spring.boot.data.CompositeKey.Entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="customer_1")
//@IdClass(CustomerId.class)
public class Customer {

//	@Id
//	private int id;
//	@Id
//	private String email;
	
	//two ways of implementing composite key is idclass and embeddable
	
	@EmbeddedId
	private CustomerId  id;
	private String name;
	
}
