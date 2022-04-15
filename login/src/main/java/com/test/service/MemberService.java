package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.member.controller.MemberRepository;
import com.test.member.entity.Member;

@Service
public class MemberService {
	@Autowired
	private MemberRepository repository;
	
	public Member memberfind(String id) {
		return repository.findById(id).get();
	}
}
