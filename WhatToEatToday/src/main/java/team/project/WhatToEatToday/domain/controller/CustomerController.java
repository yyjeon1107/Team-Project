package team.project.WhatToEatToday.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.Service.CustomerService;
import team.project.WhatToEatToday.domain.member.Customer;
import team.project.WhatToEatToday.dto.JoinForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.http.HttpRequest;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
	private final CustomerService customerService;

	@GetMapping("/mypage/{customerId}")
    public String getMypage(@PathVariable String customerId, Model model) {
        model.addAttribute("customer", customerService.findOne(customerId));
        model.addAttribute("page", "myPage");
        return "layout";
    }

    @GetMapping("/mypage/edit/{customerId}")
    public String editMypage(@PathVariable String customerId, Model model, JoinForm joinForm) {
        model.addAttribute("customer", customerService.findOne(customerId));
        model.addAttribute("JoinForm", joinForm);
        model.addAttribute("page", "editCustomerInfo");
        return "layout";
    }

    @PostMapping("/mypage/edit/{customerId}")
    public String editMypage(HttpServletRequest request , @PathVariable String customerId, @Valid JoinForm joinForm) {
        HttpSession session = request.getSession();
        Customer customer = customerService.findOne(customerId);
        customer.setName(joinForm.getName());
        customer.setPassword(joinForm.getPassword());
        customer.setEmail(joinForm.getEmail());
        customer.setTel(joinForm.getTel());
        customer.setAddress(joinForm.getAddress());
        customer.setAddressDetail(joinForm.getAddressDetail());
        customerService.edit(customer);
        session.setAttribute("message", "회원정보 변경");
        return "redirect:/customer/mypage/" + customerId;
    }

    @GetMapping("/mypage/delete/{customerId}")
    public String editMypage(HttpServletRequest request , @PathVariable String customerId) {
        HttpSession session = request.getSession();
        Customer customer = customerService.findOne(customerId);
        customerService.delete(customer);
        session.setAttribute("message", "회원탈퇴");
        return "redirect:/logout";
    }
	

	@GetMapping("/recommend")
    public String recommendMenu(Model model) {
    	model.addAttribute("page", "menuRecommend");
        return "layout";
    }

	@GetMapping("/recommendResult")
    public String recommendMenuResult(Model model) {
    	model.addAttribute("page", "menuRecommendResult");
        return "layout";

    }
	
	
	@GetMapping("/menuAll")
    public String viewMenuAll(Model model) {
    	model.addAttribute("page", "viewMenuAll");
        return "layout";
    }
	

	
}
