package team.project.WhatToEatToday.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.project.WhatToEatToday.Service.AdminService;
import team.project.WhatToEatToday.Service.CustomerService;
import team.project.WhatToEatToday.Service.ManagerService;
import team.project.WhatToEatToday.Service.MemberService;
import team.project.WhatToEatToday.domain.member.Admin;
import team.project.WhatToEatToday.domain.member.Customer;
import team.project.WhatToEatToday.domain.member.Manager;
import team.project.WhatToEatToday.domain.member.Member;
import team.project.WhatToEatToday.dto.JoinForm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {
	
	private final MemberService memberService;
    private final CustomerService customerService;


    @GetMapping("/store")
    public String all(Model model) {
    	List<Member> members = memberService.findAll();
        model.addAttribute("page", "members");
        model.addAttribute("members", members);
        return "layout";
        
    }
}
