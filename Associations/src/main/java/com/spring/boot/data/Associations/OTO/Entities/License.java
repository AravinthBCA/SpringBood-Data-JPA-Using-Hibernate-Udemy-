package com.spring.boot.data.Associations.OTO.Entities;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class License {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String type;
	@Temporal(TemporalType.DATE)
	@Column (name = "valid_from")
	private Date validFrom;
	@Temporal(TemporalType.DATE)
	@Column (name = "valid_to")
	private Date validTo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;
	
	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	
}
