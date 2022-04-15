package com.test.member.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.member.entity.Member;
import com.test.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@PostMapping("login")
	public String login() {
		return "login";
	}
	@PostMapping("join")
	public String join() {
		return "join";
	}

	@PostMapping("login/do")
	  public String loginResult(@RequestParam Member member, HttpServletRequest req) {
	        // 입력받은 ID와 PW가 DB에 있으면 아래코드 없으면 else 다시 로그인처리
			Member dbmember = memberService.memberfind(member.getUserId());
			if((dbmember == null) && (dbmember.getUserId().equals(member.getUserId()))) {
			
			HttpSession session = req.getSession();
	        
	        session.setAttribute("model", member); 
	        System.out.println("로그인 결과");
			}
			return "result";
	    }

}
