package com.spring.boot.data.DatingApi.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"userAccount"})
public class Interest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String likes;
	@Column(name="dislikes")
	private String disLikes;
	private String hobbies;
	@Column(name="profile_url")
	private String profileUrl;
	private String about;
	
	@Transient
	private int userAccountId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserAccount userAccount;
	
}
