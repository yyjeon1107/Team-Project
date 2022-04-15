package com.test.member.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Member")

public class Member {
	 @Id
	 @Column(name="userId")
	 private String userId;
	 
	 @Column(name="password")
	 private String password;
	
	 
}









