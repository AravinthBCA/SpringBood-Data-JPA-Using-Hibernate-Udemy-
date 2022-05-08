package com.spring.boot.data.FileData.Entities;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Image {

	@Id
	private Long id;
	private String name;
	@Lob
	private byte[] data;
	
}
