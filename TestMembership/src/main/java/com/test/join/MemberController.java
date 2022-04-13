package com.test.join;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;
	
	 	@GetMapping("/join")
	    public String signup(MemberForm memberForm) {
	        return "join";
	    }

	    @PostMapping("/join")
	    public String signup(@Valid MemberForm memberForm, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "join";
	        }

	        if (!memberForm.getPassword1().equals(memberForm.getPassword2())) {
	            bindingResult.rejectValue("password2", "passwordInCorrect", 
	                    "2개의 패스워드가 일치하지 않습니다.");
	            return "join";
	        }

	        memberService.create(memberForm.getUser_id(), memberForm.getPassword1(), memberForm.getName(),
	        		memberForm.getEmail(), memberForm.getAddress() );

	        return "redirect:/"; //새로고침
	    }
	
	
	
}
