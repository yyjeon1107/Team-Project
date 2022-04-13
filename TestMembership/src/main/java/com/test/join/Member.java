package com.test.join;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Member {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	 
	 @Column(unique=true)
	 private String user_id;
	 
	 
	 private String password;
	 private String name;
	 private String email;
	 private String address;
	
	

	
	
}
