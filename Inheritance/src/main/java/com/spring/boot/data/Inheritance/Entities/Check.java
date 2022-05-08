package com.spring.boot.data.Inheritance.Entities;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
//above two annotations is enough for table_per_class
//@DiscriminatorValue("ch") // single table strategy
@Table(name = "bankcheck_1")
//@PrimaryKeyJoinColumn(name = "id") //optional for joined strategy
public class Check extends Payment{

	private String checkNumber;
	
}
