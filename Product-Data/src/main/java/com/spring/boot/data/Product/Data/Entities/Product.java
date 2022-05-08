package com.spring.boot.data.Product.Data.Entities;

import java.io.Serializable;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name="description")
	private String desc;
	private Double price;
	
}
