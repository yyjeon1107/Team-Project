package com.test.member.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.member.entity.Member;


@Repository(value="repository")
public interface MemberRepository extends JpaRepository<Member, String>{
	  
}
